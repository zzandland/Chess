import java.io.*;

public class Input {
  public static InputStreamReader generateISR(InputStream IS) {
    return new InputStreamReader(IS);
  }

  public static BufferedReader generateBR(InputStream IS) {
    return new BufferedReader(generateISR(IS));
  }
}
