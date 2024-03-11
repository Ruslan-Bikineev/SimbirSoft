package ui;

import io.qameta.allure.Attachment;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureMethods {
    @Attachment(value = "Attachment", fileExtension = ".csv")
    private static byte[] getBytes() throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/report.csv"));
    }

    public void createCsvFile(String date0, String amount0, String transactionType0, String date1, String amount1, String transactionType1) throws IOException {
        ConvertDate convertDate = new ConvertDate();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(convertDate.swapDayAndMonth(date0)).append(";");
        stringBuilder.append(amount0).append(";");
        stringBuilder.append(transactionType0).append("\n");
        stringBuilder.append(convertDate.swapDayAndMonth(date1)).append(";");
        stringBuilder.append(amount1).append(";");
        stringBuilder.append(transactionType1).append("\n");
        try (FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/test/resources/report.csv")) {
            writer.write(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        getBytes();
    }

}
