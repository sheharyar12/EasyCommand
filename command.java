import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class command {
	

	
	public command()
	{
		System.out.println("Executing Command");
	}

	private String executeCommand(String command) {
		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
	
	public String shutoffComputer() throws IOException, InterruptedException{
		String output = this.executeCommand("shutdown -i");
		return output;
	}
	
	public String DisplaySystemInfo() throws IOException, InterruptedException{
		String output = this.executeCommand("systeminfo");
		return output;
	}
	
	public String ipconfigAll() throws IOException, InterruptedException{
		String output = this.executeCommand("ipconfig /all");
		return output;
	}
	
	public String pingWebsite(String website) throws IOException, InterruptedException{
		String output = this.executeCommand("ping " + website);
		return output;
	}
	
	public String listAllCommands() throws IOException, InterruptedException{
		String output = this.executeCommand("help");
		return output;
	}

	public String displayTasks() throws IOException, InterruptedException{
		String output = this.executeCommand("tasklist");
		return output;
	}
	
	public String installedDrivers() throws IOException, InterruptedException{
		String output = this.executeCommand("driverquery");
		return output;
	}
	
	public String netView() throws IOException, InterruptedException{
		System.out.println("Searching...");
		String output = this.executeCommand("net view");
		return output;
	}
	
	public String netUsers() throws IOException, InterruptedException{
		System.out.println("All users");
		String output = this.executeCommand("net user");
		return output;
	}
	
	public String netUserInfo(String name) throws IOException, InterruptedException{
		String output = this.executeCommand("net user " + name);
		return output;
	}
	
	public String changePassoword(String name) throws IOException, InterruptedException{
		String output = this.executeCommand("net user " + name + " *");
		return output;
	}
}
