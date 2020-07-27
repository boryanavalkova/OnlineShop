import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ActivityActions {
	private String FileName; 
	
	public ActivityActions(String FileName) {
		this.FileName = FileName;
	}
	
	public void writeActivity(String info) {
		BufferedWriter bw = null;
		try {
			
			bw = new BufferedWriter(new FileWriter("ActivityLog.txt", true));
			bw.write(info + ", ");	

		} catch(IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		finally {
			
			try {
				
				if(bw != null) {
					bw.close();
				}
			
			} catch(IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
