package file;

import java.io.*;

public class LeituraArquivoNotas {
    public static void main(String[] args) {
        String caminho = "D:\\Projetos java\\DAO\\src\\file\\notas.txt";

        File notas = new File(caminho);

        try (BufferedReader br = new BufferedReader(new FileReader(notas))){

            Double soma = 0.0;
            Double media = 0.0;
            String linha;
            Integer qtdLinhas = 0;

            br.readLine();
            while ((linha = br.readLine()) != null){
                String[] posicoes = linha.split(",");
                soma += Double.parseDouble(posicoes[1]);
                String nome = posicoes[0];
                Integer nota = Integer.parseInt(posicoes[1]);



                System.out.println("Aluno: "+nome +" | nota: "+ nota);
                if(nota > 80){
                    System.out.println("Aprovado");
                }else{
                    System.out.println("Reprovado");
                }
                qtdLinhas++;
            }
            media = soma / qtdLinhas;
            System.out.println("Media notas da turma: "+media);
        }catch (FileNotFoundException e){
            System.out.println("Erro ao buscar o arquivo.");
        }catch (IOException e){
            System.out.println("Erro ao abrir o arquivo.");
        }
    }
}
