package fbcmd4j;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import java.util.Scanner;

import com.restfb.BinaryAttachment;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;
import com.restfb.batch.*;

import java.util.Date;
/**
 * @author Ismael
 *
 */
public class Main {	
	private static final String APP_VERSION = "v2.11";

	public static void main(String[] args) {
		FacebookClient facebookClient = new DefaultFacebookClient();
		String aT;
		int option;
		
		try (Scanner scanner = new Scanner(System.in)){
			while(true){
				System.out.println("\n");
				System.out.format("Facebook java client %s\n\n", APP_VERSION);
				System.out.println("Opciones: ");
				System.out.println("(1) INICIAR SESION");
				System.out.println("(2) PUBLICAR");
				System.out.println("(3) INFORMACION DE LA CUENTA");
				System.out.println("(4) SALIR");
				System.out.println("\nINGRESE UNA OPCION ");
				option = scanner.nextInt();
				scanner.nextLine();
				
				switch(option){
					case 1:
						System.out.println("ACCESS TOKEN:EAAP8FVUJKnUBADDwPhbnSrb5hpxyL24USbTa5h5ZCZBTaCGq2jlHNA1XE01ZCaoZBM4xrmI1jEjMPyqxYG8hkG3j2hOyssg29tj68EEIrZCZBs7kQa983NIwxOz9X1yQx8BpJRecOGkiD9fyx4O4tOaPGx6vEoGlwicrZAo3ma8woWkb0kD1cjccQcJkafumfwZD (Copy this) ");
						System.out.print("ACCESS TOKEN: ");
						aT = scanner.nextLine();
						facebookClient = new DefaultFacebookClient(aT);
						break;
					case 2:
						System.out.print("ESCRIBA POST: ");
						String msj = scanner.nextLine();
						FacebookType publishMessageResponse = facebookClient.publish("me/feed", FacebookType.class,
						    Parameter.with("message", msj));
						System.out.print("Post Escrito con Exito!!");
						break;
					case 3:
						User user = facebookClient.fetchObject("me", User.class);  
						System.out.println("NOMBRE USUARIO: " + user.getName());
						System.out.println("Correo " + user.getEmail());
						System.out.println("Cumpleaños: " + user.getBirthday());
						break;
					case 4:
						System.out.println("Haz salido correctamente de la aplicacion");
						System.exit(0);
						break;
					default:
						continue;

			}
			}
	}}}