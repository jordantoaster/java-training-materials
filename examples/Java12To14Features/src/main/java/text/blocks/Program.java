package text.blocks;

public class Program {
    public static void main(String[] args) {
        String quote1 = """
            More than Prince of Cats. 
            Oh, he’s the courageous captain of compliments.
            """;

        String quote2 = """
            More than Prince of Cats. 
            Oh, he’s the courageous captain of compliments.""";

        String quote3 = """
            More than Prince of Cats. 
            Oh, he’s the courageous captain of compliments. 
            He fights as you sing prick-song, keeps time, distance, and proportion. 
            He rests his minim rests—one, two, and the third in your bosom. 
            The very butcher of a silk button, a duelist, a duelist, a gentleman of the 
            very first house of the first and second cause. 
            Ah, the immortal Passado, the Punto Reverso, the Hai!
            """;

        String quote4 = """
            More than Prince of Cats. 
            Oh, he’s the courageous captain of compliments. 
            He fights as you sing prick-song, keeps time, distance, and proportion. 
            He rests his minim rests—one, two, and the third in your bosom. 
            The very butcher of a silk button, a duelist, a duelist, a gentleman of the 
            very first house of the first and second cause. 
            Ah, the immortal Passado, the Punto Reverso, the Hai!
    """;

        String quote5 = """
            More than Prince of Cats. 
              Oh, he’s the courageous captain of compliments. 
                He fights as you sing prick-song, keeps time, distance, and proportion. 
                  He rests his minim rests—one, two, and the third in your bosom. 
                    The very butcher of a silk button, a duelist, a duelist, a gentleman of the 
                      very first house of the first and second cause. 
                        Ah, the immortal Passado, the Punto Reverso, the Hai!
            """;

        String quote6 = """
            More than Prince of Cats. 
            Oh, he’s the courageous captain of compliments. 
            He fights as you sing prick-song, keeps time, distance, and proportion. 
            He rests his minim rests—one, two, and the third in your bosom. 
            The very butcher of a silk button, a duelist, a duelist, a gentleman of the \
            very first house of the first and second cause. 
            Ah, the immortal Passado, the Punto Reverso, the Hai!
            """;

        String quote7 = """
            More than Prince of Cats. 
            Oh, he’s the courageous captain of compliments. 
            He fights as you sing prick-song, keeps time, distance, and proportion. 
            He rests his minim rests - %d, %d, and %d in your bosom. 
            The very butcher of a silk button, %4$s, %4$s, a gentleman of the \
            very first house of the first and second cause. 
            Ah, the immortal %5$s, the %6$s, the %7$s!
            """;

        showFinalNewline(quote1, quote2);
        showIncidentalWhiteSpace(quote3, quote4, quote5);
        showEscapingLineTerminator(quote6);
        showFormatting(quote7);
    }

    private static void showFinalNewline(String input1, String input2) {
        printWithLines(input1);
        printWithLines(input2);
    }

    private static void showIncidentalWhiteSpace(String input1, String input2, String input3) {
        printWithLines(input1);
        printWithLines(input2);
        printWithLines(input3);
    }

    private static void showEscapingLineTerminator(String input) {
        printWithLines(input);
    }

    private static void printWithLines(String input) {
        System.out.println("--------------------");
        System.out.print(input);
        System.out.println("--------------------");
    }

    private static void showFormatting(String input) {
        input = input.formatted(1, 2, 3, "a duelist", "Passado", "Punto Reverso", "Hai");
        printWithLines(input);
    }
}
