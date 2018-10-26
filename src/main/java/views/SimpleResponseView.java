package views;

public class SimpleResponseView implements View {

    private String result;

    private SimpleResponseView(String result) {
        this.result = result;
    }

    public static SimpleResponseView getOkResponse() {
        return new SimpleResponseView("OK");
    }

    public static SimpleResponseView getKoResponse() {
        return new SimpleResponseView("KO");
    }

    @Override
    public String getHtml() {
        return "{ \"operation\":{\"result\":\"" + result + "\"}}";
    }
}
