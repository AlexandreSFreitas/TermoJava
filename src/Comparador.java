import java.util.Random;
import java.util.Scanner;

public class Comparador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] palavraSecreta = {
                "VASCO",
                "CASAS",
                "LIVRO",
                "PRAIA",
                "NUVEM",
                "MOUSE"
        };
        int indice = random.nextInt(palavraSecreta.length);
        String palavraSec = palavraSecreta[indice];

        for (int tentavias = 0; tentavias < 5; tentavias++){
            String[] resultado = new String[palavraSec.length()];
            boolean[] usado = new boolean[palavraSec.length()];

            System.out.println("DIGITE A PALAVRA CORRETA, NUMERO DE TENTATIVAS: " +(tentavias+1) +" de 5");
            String palavraTentada = scanner.next().toUpperCase();
            while (palavraTentada.length() != palavraSec.length() ){
                System.out.println("TAMANHO DA PALAVRA ERRADA, APENAS"+ palavraSec.length() +"LETRAS, NUMERO DE TENTATIVAS: " +(tentavias+1) +" de 5");
                palavraTentada = scanner.next().toUpperCase();
            }

            for (int i = 0; i < palavraSec.length(); i++) {
                if (palavraTentada.charAt(i) == palavraSec.charAt(i)) {
                    usado[i] = true;
                    resultado[i] = "🟩";
                }
            }
            for (int i = 0; i < palavraSec.length(); i++) {
                if (!"🟩".equals(resultado[i])) {
                    for (int j = 0; j < palavraSec.length(); j++){
                        if(palavraTentada.charAt(i) == palavraSec.charAt(j) && !usado[j]){
                            usado[j] = true;
                            resultado[i] = "🟨";
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < palavraSec.length(); i++) {
                if (!"🟩".equals(resultado[i]) && !"🟨".equals(resultado[i])){
                    resultado[i] = "🟥";
                }
            }
            for (int i = 0; i < resultado.length; i++) {
                System.out.print(resultado[i]);
            }
            if(palavraTentada.equals(palavraSec)){
                System.out.println("Parabéns você ganhou, a palavra era: " + palavraSec);
                break;
            }else if(tentavias == 4){
                System.out.println("Infelizmente você perdeu, a palavra era: " + palavraSec);
            }
        }
        }
    }

