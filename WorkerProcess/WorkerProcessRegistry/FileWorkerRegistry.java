package WorkerProcessRegistry;

import java.io.File;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.ArrayList;
import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;

public class FileWorkerRegistry implements IWorkerRegistry {

    private static FileWorkerRegistry instance; 

	private String registryFile = "/home/tawfik/BullyAlgorithmSimulation/data/registry/registryList.rgl";

	private FileWorkerRegistry(){}

	public static FileWorkerRegistry getInstance()  
	  { 
	    if (instance == null)  
	    { 
	      instance = new FileWorkerRegistry(); 
	    } 
	    return instance; 
	  } 


  public void register(String processID){
  	try {
      FileWriter myWriter = new FileWriter(registryFile, true);
      myWriter.write(processID + "\n");
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public String[] listRegistered(){
  		  	Path filePath = new File(registryFile).toPath();
		Charset charset = Charset.defaultCharset();
		List<String> stringList = new ArrayList<String>();
	try {
        stringList = Files.readAllLines(filePath, charset);
	} catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	}

if(stringList == null){
	return new String[0];
}else {
			String[] processList = stringList.toArray(new String[]{});

		return processList;
}


  }
}

