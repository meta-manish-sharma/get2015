import org.apache.commons.lang3.StringEscapeUtils;

public class ScriptUnicode {

	public static void main(String[] args) throws Exception {

		String results = StringEscapeUtils.escapeHtml4("<div>alert('hello');</div>");
		System.out.println(results);

	}

}