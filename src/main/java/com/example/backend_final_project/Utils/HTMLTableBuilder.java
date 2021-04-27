package com.example.backend_final_project.Utils;

public class HTMLTableBuilder {


    private int columns;
    private final StringBuilder table = new StringBuilder();
    public static String HTML_START = "<html>";
    public static String HTML_END = "</html>";
    public static String HEAD_START = "<head>";
    public static String HEAD_END = "</head>";
    public static String STYLE = "<style>@import \"compass/css3\";\n" +
            "\n" +
            "table {\n" +
            "  font-family: 'Arial';\n" +
            "  margin: 25px auto;\n" +
            "  border-collapse: collapse;\n" +
            "  border: 1px solid #eee;\n" +
            "  border-bottom: 2px solid #00cccc;\n" +
            "  box-shadow: 0px 0px 20px rgba(0,0,0,0.10),\n" +
            "     0px 10px 20px rgba(0,0,0,0.05),\n" +
            "     0px 20px 20px rgba(0,0,0,0.05),\n" +
            "     0px 30px 20px rgba(0,0,0,0.05);\n" +
            "  tr {\n" +
            "     &:hover {\n" +
            "      background: #f4f4f4;\n" +
            "      \n" +
            "      td {\n" +
            "        color: #555;\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "  th, td {\n" +
            "    color: #999;\n" +
            "    border: 1px solid #eee;\n" +
            "    padding: 12px 35px;\n" +
            "    border-collapse: collapse;\n" +
            "  }\n" +
            "  th {\n" +
            "    background: #00cccc;\n" +
            "    color: #fff;\n" +
            "    text-transform: uppercase;\n" +
            "    font-size: 12px;\n" +
            "    &.last {\n" +
            "      border-right: none;\n" +
            "    }\n" +
            "  }\n" +
            "}</style>";
    public static String JS = "<script>$('table tr').each(function(){\n" +
            "  $(this).find('th').first().addClass('first');\n" +
            "  $(this).find('th').last().addClass('last');\n" +
            "  $(this).find('td').first().addClass('first');\n" +
            "  $(this).find('td').last().addClass('last');\n" +
            "});\n" +
            "\n" +
            "$('table tr').first().addClass('row-first');\n" +
            "$('table tr').last().addClass('row-last');</script>";
    public static String JQUERY = "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>";
    public static String TABLE_START_BORDER = "<table border=\"1\">";
    public static String TABLE_START = "<table>";
    public static String TABLE_END = "</table>";
    public static String HEADER_START = "<th>";
    public static String HEADER_END = "</th>";
    public static String ROW_START = "<tr>";
    public static String ROW_END = "</tr>";
    public static String COLUMN_START = "<td>";
    public static String COLUMN_END = "</td>";


    /**
     * @param header
     * @param border
     * @param rows
     * @param columns
     */
    public HTMLTableBuilder(String header, boolean border, int rows, int columns) {
        this.columns = columns;
        if (header != null) {
            table.append("<b>");
            table.append(header);
            table.append("</b>");
        }
        table.append(HTML_START);
        table.append(HEAD_START);
        table.append(JQUERY);
        table.append(JS);
        table.append(STYLE);
        table.append(HEAD_END);
        table.append(border ? TABLE_START_BORDER : TABLE_START);
        table.append(TABLE_END);
        table.append(HTML_END);
    }


    /**
     * @param values
     */
    public void addTableHeader(String... values) {
        if (values.length != columns) {
            System.out.println("Error column lenth");
        } else {
            int lastIndex = table.lastIndexOf(TABLE_END);
            if (lastIndex > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(ROW_START);
                for (String value : values) {
                    sb.append(HEADER_START);
                    sb.append(value);
                    sb.append(HEADER_END);
                }
                sb.append(ROW_END);
                table.insert(lastIndex, sb.toString());
            }
        }
    }


    /**
     * @param values
     */
    public void addRowValues(String... values) {
        if (values.length != columns) {
            System.out.println("Error column lenth");
        } else {
            int lastIndex = table.lastIndexOf(ROW_END);
            if (lastIndex > 0) {
                int index = lastIndex + ROW_END.length();
                StringBuilder sb = new StringBuilder();
                sb.append(ROW_START);
                for (String value : values) {
                    sb.append(COLUMN_START);
                    sb.append(value);
                    sb.append(COLUMN_END);
                }
                sb.append(ROW_END);
                table.insert(index, sb.toString());
            }
        }
    }


    /**
     * @return
     */
    public String build() {
        return table.toString();
    }
}

