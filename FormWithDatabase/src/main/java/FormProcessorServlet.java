import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class FormProcessorServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){

        System.out.println("Request has arrived");

        String full_name = request.getParameter("fullName");
        String username = request.getParameter("username");
        String city = request.getParameter("city");
        String uPassword = request.getParameter("password");

        Properties properties = new Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        String query = "INSERT INTO USER VALUES(?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn  = DriverManager.getConnection(url,user,password);
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1,full_name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,uPassword);
            preparedStatement.setString(4,city);

            int update = preparedStatement.executeUpdate();
            PrintWriter pw = response.getWriter();

            request.setAttribute("fullName",full_name);

            if(update != 0){
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            }else{
                pw.println("<h1> There is some issue with the registration, please try again later</h1>");
            }

        } catch (SQLException | IOException | ClassNotFoundException | ServletException e) {
            throw new RuntimeException(e);
        }

    }

}
/**
 * I get this logs after user registration when i stop the program:
 *
 * 24-Sep-2026 14:20:40.594 INFO [Thread-1] org.apache.coyote.AbstractProtocol.pause Pausing ProtocolHandler ["http-nio-9020"]
 *
 * 24-Sep-2026 14:20:40.604 INFO [Thread-1] org.apache.catalina.core.StandardService.stopInternal Stopping service [Catalina]
 *
 * 24-Sep-2026 14:20:40.616 WARNING [Thread-1] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesJdbc The web application [FormWithDatabase] registered the JDBC driver [com.mysql.cj.jdbc.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
 *
 * 24-Sep-2026 14:20:40.616 WARNING [Thread-1] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesThreads The web application [FormWithDatabase] appears to have started a thread named [mysql-cj-abandoned-connection-cleanup] but has failed to stop it. This is very likely to create a memory leak. Stack trace of thread:
 *
 *  java.base/jdk.internal.misc.Unsafe.park(Native Method)
 *
 *  java.base/java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:269)
 *
 *  java.base/java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:1847)
 *
 *  java.base/java.lang.ref.ReferenceQueue.await(ReferenceQueue.java:71)
 *
 *  java.base/java.lang.ref.ReferenceQueue.remove0(ReferenceQueue.java:143)
 *
 *  java.base/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:218)
 *
 *  com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:84)
 *
 *  java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
 *
 *  java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
 *
 *  java.base/java.lang.Thread.run(Thread.java:1583)
 *
 * 24-Sep-2026 14:20:40.617 INFO [Thread-1] org.apache.coyote.AbstractProtocol.stop Stopping ProtocolHandler ["http-nio-9020"]
 *
 * 24-Sep-2026 14:20:40.635 INFO [Thread-1] org.apache.coyote.AbstractProtocol.destroy Destroying ProtocolHandler ["http-nio-9020"]
 *
 * 24-Sep-2026 14:20:40.636 INFO [mysql-cj-abandoned-connection-cleanup] org.apache.catalina.loader.WebappClassLoaderBase.checkStateForResourceLoading Illegal access: this web application instance has been stopped already. Could not load []. The following stack trace is thrown for debugging purposes as well as to attempt to terminate the thread which caused the illegal access.
 *
 * 	java.lang.IllegalStateException: Illegal access: this web application instance has been stopped already. Could not load []. The following stack trace is thrown for debugging purposes as well as to attempt to terminate the thread which caused the illegal access.
 *
 * 		at org.apache.catalina.loader.WebappClassLoaderBase.checkStateForResourceLoading(WebappClassLoaderBase.java:1244)
 *
 * 		at org.apache.catalina.loader.WebappClassLoaderBase.getResource(WebappClassLoaderBase.java:854)
 *
 * 		at com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkThreadContextClassLoader(AbandonedConnectionCleanupThread.java:116)
 *
 * 		at com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:83)
 *
 * 		at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
 *
 * 		at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
 *
 * 		at java.base/java.lang.Thread.run(Thread.java:1583)
 *
 *
 *
 * Also when I stop it after the users url I get this:
 *
 * 24-Sep-2026 14:22:34.506 INFO [Thread-1] org.apache.coyote.AbstractProtocol.pause Pausing ProtocolHandler ["http-nio-9020"]
 *
 * 24-Sep-2026 14:22:34.517 INFO [Thread-1] org.apache.catalina.core.StandardService.stopInternal Stopping service [Catalina]
 *
 * 24-Sep-2026 14:22:34.527 WARNING [Thread-1] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesJdbc The web application [FormWithDatabase] registered the JDBC driver [com.mysql.cj.jdbc.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
 *
 * 24-Sep-2026 14:22:34.527 WARNING [Thread-1] org.apache.catalina.loader.WebappClassLoaderBase.clearReferencesThreads The web application [FormWithDatabase] appears to have started a thread named [mysql-cj-abandoned-connection-cleanup] but has failed to stop it. This is very likely to create a memory leak. Stack trace of thread:
 *
 *  java.base/jdk.internal.misc.Unsafe.park(Native Method)
 *
 *  java.base/java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:269)
 *
 *  java.base/java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:1847)
 *
 *  java.base/java.lang.ref.ReferenceQueue.await(ReferenceQueue.java:71)
 *
 *  java.base/java.lang.ref.ReferenceQueue.remove0(ReferenceQueue.java:143)
 *
 *  java.base/java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:218)
 *
 *  com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:84)
 *
 *  java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
 *
 *  java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
 *
 *  java.base/java.lang.Thread.run(Thread.java:1583)
 *
 * 24-Sep-2026 14:22:34.528 INFO [Thread-1] org.apache.coyote.AbstractProtocol.stop Stopping ProtocolHandler ["http-nio-9020"]
 *
 * 24-Sep-2026 14:22:34.531 INFO [Thread-1] org.apache.coyote.AbstractProtocol.destroy Destroying ProtocolHandler ["http-nio-9020"]
 */
