package graph;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

    public Message(Object input_message) {
        this.data = input_message.toString().getBytes();
        this.asText = input_message.toString();
        this.asDouble = parseDoubleOrNaN(input_message.toString());
        this.date = Date.from(java.time.Instant.now());
    }

    private double parseDoubleOrNaN(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}
