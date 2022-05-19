package net.hibiznet.comm.util;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/**
 * Utility class  to support to close resources
 * @author Vincent Han
 * @since 2014.09.18
 * @version 1.0
 * @see
 *
 * <pre>
 * << 媛쒖젙�씠�젰(Modification Information) >>
 *   
 *   �닔�젙�씪        �닔�젙�옄       �닔�젙�궡�슜
 *  -------       --------    ---------------------------
 *   2014.09.18	�몴以��봽�젅�엫�썙�겕�꽱�꽣	理쒖큹 �깮�꽦
 *
 * </pre>
 */
public class ResourceCloseHelper {
	/**
	 * Resource close 泥섎━.
	 * @param resources
	 */
	public static void close(Closeable  ... resources) {
		for (Closeable resource : resources) {
			if (resource != null) {
				try {
					resource.close();
				} catch (IOException ignore) {//KISA 蹂댁븞�빟�젏 議곗튂 (2018-10-29, �쑄李쎌썝)
					BasicLogger.ignore("Occurred IOException to close resource is ingored!!");
				} catch (Exception ignore) {
					BasicLogger.ignore("Occurred Exception to close resource is ingored!!");
				}
			}
		}
	}
	
	/**
	 * JDBC 愿��젴 resource 媛앹껜 close 泥섎━
	 * @param objects
	 */
	public static void closeDBObjects(Wrapper ... objects) {
		for (Object object : objects) {
			if (object != null) {
				if (object instanceof ResultSet) {
					try {
						((ResultSet)object).close();
					} catch (SQLException ignore) {//KISA 蹂댁븞�빟�젏 議곗튂 (2018-10-29, �쑄李쎌썝)
						BasicLogger.ignore("Occurred SQLException to close resource is ingored!!");
					} catch (Exception ignore) {
						BasicLogger.ignore("Occurred Exception to close resource is ingored!!");
					}
				} else if (object instanceof Statement) {
					try {
						((Statement)object).close();
					} catch (SQLException ignore) {//KISA 蹂댁븞�빟�젏 議곗튂 (2018-10-29, �쑄李쎌썝)
						BasicLogger.ignore("Occurred SQLException to close resource is ingored!!");
					} catch (Exception ignore) {
						BasicLogger.ignore("Occurred Exception to close resource is ingored!!");
					}
				} else if (object instanceof Connection) {
					try {
						((Connection)object).close();
					} catch (SQLException ignore) {
						BasicLogger.ignore("Occurred SQLException to close resource is ingored!!");
					} catch (Exception ignore) {
						BasicLogger.ignore("Occurred Exception to close resource is ingored!!");
					}
				} else {
					throw new IllegalArgumentException("Wrapper type is not found : " + object.toString());
				}
			}
		}
	}
	
	/**
	 * Socket 愿��젴 resource 媛앹껜 close 泥섎━
	 * @param objects
	 */
	public static void closeSocketObjects(Socket socket, ServerSocket server) {
		if (socket != null) {
			try {
				socket.shutdownOutput();
			} catch (IOException ignore) {
				BasicLogger.ignore("Occurred IOException to close resource is ingored!!");
			} catch (Exception ignore) {
				BasicLogger.ignore("Occurred Exception to shutdown ouput is ignored!!");
			}
			
			try {
				socket.close();
			} catch (IOException ignore) {
				BasicLogger.ignore("Occurred IOException to close resource is ingored!!");
			} catch (Exception ignore) {
				BasicLogger.ignore("Occurred Exception to close resource is ignored!!");
			}
		}
		
		if (server != null) {
			try {
				server.close();
			} catch (IOException ignore) {
				BasicLogger.ignore("Occurred IOException to close resource is ingored!!");
			} catch (Exception ignore) {
				BasicLogger.ignore("Occurred Exception to close resource is ignored!!");
			}
		}
	}
	
	/**
	 *  Socket 愿��젴 resource 媛앹껜 close 泥섎━
	 *  
	 * @param sockets
	 */
	public static void closeSockets(Socket ... sockets) {
		for (Socket socket : sockets) {
			if (socket != null) {
				try {
					socket.shutdownOutput();
				} catch (IOException ignore) {
					BasicLogger.ignore("Occurred IOException to close resource is ingored!!");
				} catch (Exception ignore) {
					BasicLogger.ignore("Occurred Exception to shutdown ouput is ignored!!");
				}
				
				try {
					socket.close();
				} catch (IOException ignore) {
					BasicLogger.ignore("Occurred IOException to close resource is ingored!!");
				} catch (Exception ignore) {
					BasicLogger.ignore("Occurred Exception to close resource is ignored!!");
				}
			}
		}
	}
}