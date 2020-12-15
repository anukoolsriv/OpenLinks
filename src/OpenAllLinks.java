import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;

public class OpenAllLinks {

	public static int getLength(Process process) throws IOException {
		int length = 0;

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {

			String line;
			while ((line = reader.readLine()) != null) {
				for (int j = 0; j < line.length(); j++) {
					String c = line.substring(line.length() - 2, line.length());
//            		System.out.println(line.indexOf(": "));

					if (c.contains(" ")) {
						c = c.substring(c.length() - 1);
					}
//            		System.out.println(c);
					length = Integer.parseInt(c);
				}
//                System.out.println(line);
			}
		}
		System.out.println(length);

		return length;

	}

	public static void openLinks() throws IOException {
		try {
			for (int i = 1; i < 4; i++) {
//				File file = new File("files/1.txt");
//				Scanner sc = new Scanner(file);
				String command = "find /i \"http\" /c \"" + i + ".txt\"";
//				System.out.println(command);
//				String command = "";
				ProcessBuilder processBuilder = new ProcessBuilder();
//				processBuilder.command("cmd.exe","/c","find /i \"http\" /c \"1.txt\"");
//				List<String> commands = new ArrayList<String>();
				processBuilder.command("cmd.exe", "/c", command).directory(new File("files"));

				Process process = processBuilder.start();

				int length = getLength(process);

				
				
				
				
////				while(sc.hasNextLine()) {
////					String url = sc.nextLine();
////					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
////					System.out.println(sc.nextLine());
////				}
//				}
//						
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		openLinks();

//		for (int i = 1; i < 4; i++) {
//			int noOfLines = 0;
//			try (BufferedReader reader = new BufferedReader(new FileReader("files/"+i+".txt"))) {
//				while (reader.readLine() != null) {
//					noOfLines++;
//				}
//			}	
//			
//			System.out.println(noOfLines);
//		}

	}
}
