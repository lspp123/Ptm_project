package graph;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;

    public Message(String message_text) {
        this.data = message_text.getBytes().clone();
        this.asText = message_text;
        this.asDouble = parseDoubleOrNaN(message_text);
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
