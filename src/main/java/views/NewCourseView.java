package views;

public class NewCourseView implements View{

    @Override
    public String getHtml() {
        return createView();
    }

    private String createView() {
        return new StringBuilder()
                .append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("    <head>\n")
                .append("        <title>Nuevo curso</title>\n")
                .append("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" \n")
                .append("              integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n")
                .append("    </head>\n")
                .append("    <body>\n")
                .append("        <div class=\"w-50 p-3 mx-auto\">\n")
                .append("            <form action = \"/courses?param=add\" method = \"POST\">\n")
                .append("                <div class=\"form-group\">\n")
                .append("                    <label for=\"title\">Title</label>\n")
                .append("                    <input type=\"text\" class=\"form-control\" id=\"title\" name=\"title\" placeholder=\"Python for experts\">\n")
                .append("                </div>\n")
                .append("                <div class=\"form-group\">\n")
                .append("                    <label for=\"duration\">Duration (In hours)</label>\n")
                .append("                    <input type=\"number\" class=\"form-control\" id=\"duration\" name=\"duration\" placeholder=\"99\">\n")
                .append("                </div>\n")
                .append("                <div class=\"form-group\">\n")
                .append("                    <label for=\"level\">Another label</label>\n")
                .append("                    <select class=\"form-control\" id=\"level\" name=\"level\">\n")
                .append("                        <option>Advanced</option>\n")
                .append("                        <option>Medium</option>\n")
                .append("                        <option>Basic</option>\n")
                .append("                    </select>\n")
                .append("                </div>\n")
                .append("                <div class=\"form-check\">\n")
                .append("                    <input type=\"checkbox\" class=\"form-check-input\" id=\"active\" name=\"active\">\n")
                .append("                    <label class=\"form-check-label\" for=\"active\">Course is active</label>\n")
                .append("                </div>\n")
                .append("                <div class=\"mx-auto\" style=\"width: 270px;\">\n")
                .append("                    <button type=\"submit\" class=\"btn btn-primary\">Add course</button>\n")
                .append("                    <button type=\"reset\" class=\"btn btn-secondary\">Reset</button>\n")
                .append("                </div>\n")
                .append("            </form>\n")
                .append("        </div>\n")
                .append("    </body>\n")
                .append("</html>\n")
                .toString();
    }
}
