package adventofcode.utils;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;
import java.util.stream.*;

public class FileHandler {
	private static final Logger LOGGER = Logger.getLogger(FileHandler.class.getName());
	private static final String FILE_COULD_NOT_BE_FOUND = "File could not be found";

	public static List<String> readFileIntoList(String inputFile){
		String file = FileHandler.class.getClassLoader().getResource(inputFile).getFile();
		List<String> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			list.add(line);
			while (line != null) {
				line = br.readLine();
				if(line != null) {
					list.add(line);
				}
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE,FILE_COULD_NOT_BE_FOUND);
			e.printStackTrace();
		}
		return list;
	}


	public List<String> readFileAsObjectSeparatedByBlankLines(String file){
		List<String> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {


			List<String> tempList = new ArrayList<>();
			String line = "";

			while (line != null) {
				line = br.readLine();
				if(line != null) { //Temporary bug fix
					tempList.add(line);
				}


			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<tempList.size(); i++){
				sb.append(tempList.get(i));
				sb.append(";");
			}

		} catch (IOException e) {
			LOGGER.log(Level.SEVERE,FILE_COULD_NOT_BE_FOUND);
			e.printStackTrace();
		}
		return list;
	}

	public String readFileIntoString(String file){
		return readLineByLineJava8(file);
	}

	private static String readLineByLineJava8(String filePath)
	{
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8))
		{
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public int[] readCommaSeparatedFile(String file){
		String[] values = new String[0];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			values = line.split(",");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE,FILE_COULD_NOT_BE_FOUND);
			e.printStackTrace();
		}
		int[] intValues = new int[values.length];

		for (int i = 0; i< values.length; i++){
			intValues[i] = Integer.parseInt(values[i]);
		}
		return intValues;
	}

}