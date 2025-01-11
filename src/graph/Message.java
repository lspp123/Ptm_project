package graph;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

    public Message(Object inputMessage) {
        if (inputMessage instanceof byte[])
            this.data = (byte[]) inputMessage;
        else
            this.data = inputMessage.toString().getBytes();

        this.asText = new String(this.data);
        this.asDouble = parseDoubleOrNaN(this.asText);
        this.date = Date.from(java.time.Instant.now());
    }

    private static double parseDoubleOrNaN(String input) {
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

}
