import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
public class PortScanner {
    
    /**
     * Scans a range of ports on the target host and prints the open ports.
     *
     * @param targetHost The IP address or hostname of the target host.
     * @param startPort  The starting port number to scan.
     * @param endPort    The ending port number to scan.
     */
    public static void portScan(String targetHost, int startPort, int endPort) {
        for (int port = startPort; port <= endPort; port++) {
            try (Socket socket = new Socket()) {
                // Set a timeout for the connection attempt
                socket.connect(new InetSocketAddress(targetHost, port), 100);
                System.out.println("Port " + port + " is open");
            } catch (IOException e) {
                // Port is closed or host is unreachable
                // We can ignore the exception as we are only interested in open ports
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        // Input for target host
        System.out.print("Enter the target host (IP or hostname): ");
        String targetHost = scanner.nextLine();
        
        // Input for starting port
        System.out.print("Enter the starting port number: ");
        int startPort = Integer.parseInt(scanner.nextLine());
        
        // Input for ending port
        System.out.print("Enter the ending port number: ");
        int endPort = Integer.parseInt(scanner.nextLine());
        
        // Call the port scanning method
        portScan(targetHost, startPort, endPort);
        
        // Close the scanner
        scanner.close();
    }
    }
