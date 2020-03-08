package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

public class Report {

	public static void main(String[] args) throws IOException {
		generateDemoReport();
	}

	public static void generateDemoReport() throws IOException {
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber.json");
		String projectName = "Bank of Guru";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setSortingMethod(SortingMethod.NATURAL);
		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
		configuration.setTrendsStatsFile(new File("target/trends.json"));
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();

	}
}
