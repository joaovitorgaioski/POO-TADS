
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<>();
        ArrayList<Caminhao> caminhoes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int opcao = 1, indexCarro = -1, indexCaminhao = -1, kmRodados = 0;
        
        while (opcao != 0) {
            linhaHorizontal();
            System.out.println("O que deseja fazer?\n(1) - Cadastrar veículo\t\t(2) - Dados do veículo\n(3) - Listar todos os veículos\t(4) - Percorrer / Incrementar quilometragem\n(5) - Visualizar quilometragens\t(0) - SAIR");
            opcao = scan.nextInt();
            linhaHorizontal();

            switch (opcao) {
                case 1:
                    System.out.println("O que você deseja adicionar?\n(1) - Carro de passeio\t(2) - Caminhão");
                    opcao = scan.nextInt();
                    if (opcao == 1) {
                        indexCarro++;
                        carros.add(new Carro());
                        System.out.print("Marca: ");
                        carros.get(indexCarro).setMarca(scan.next());
                        System.out.print("Modelo: ");
                        carros.get(indexCarro).setModelo(scan.next());
                        System.out.print("Placa: ");
                        carros.get(indexCarro).setPlaca(scan.next());
                        System.out.print("Quilometragem (km): ");
                        carros.get(indexCarro).setQuilometragem(scan.nextInt());
                        System.out.print("Capacidade de passageiros: ");
                        carros.get(indexCarro).setCapacidadePassageiros(scan.nextInt());
                    } else if (opcao == 2) {
                        indexCaminhao++;
                        caminhoes.add(new Caminhao());
                        System.out.print("Marca: ");
                        caminhoes.get(indexCaminhao).setMarca(scan.next());
                        System.out.print("Modelo: ");
                        caminhoes.get(indexCaminhao).setModelo(scan.next());
                        System.out.print("Placa: ");
                        caminhoes.get(indexCaminhao).setPlaca(scan.next());
                        System.out.print("Quilometragem (km): ");
                        caminhoes.get(indexCaminhao).setQuilometragem(scan.nextInt());
                        System.out.print("Capacidade de carga (kg): ");
                        caminhoes.get(indexCaminhao).setCapacidadeCarga(scan.nextInt());
                    } else {
                        System.out.println("Erro: opção inválida");
                    }
                    break;

                case 2:
                    System.out.println("Qual o tipo do veículo que gostaria de visualizar os dados?\n(1) - Carros de passeio\t(2) - Caminhão");
                    opcao = scan.nextInt();

                    System.out.println("Escolha um dos veículos cadastrados:");
                    switch (opcao) {
                        case 1:
                            for (int i = 0; i < carros.size(); i++) {
                                System.out.println(i + " - " + carros.get(i).getModelo());
                            }
                            carros.get(scan.nextInt()).exibirStatus();
                            break;

                        case 2:
                            for (int i = 0; i < caminhoes.size(); i++) {
                                System.out.println(i + " - " + caminhoes.get(i).getModelo());
                            }
                            caminhoes.get(scan.nextInt()).exibirStatus();
                            break;

                        default:
                            System.out.println("Erro: escolha uma opção válida");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("\tCarros:");
                    for (int i = 0; i < carros.size(); i++) {
                        System.out.print("\t\t");
                        System.out.println(carros.get(i).exibirStatusConcatenado());
                    }

                    System.out.println("\n\tCaminhões:");
                    for (int i = 0; i < caminhoes.size(); i++) {
                        System.out.print("\t\t");
                        System.out.println(caminhoes.get(i).exibirStatusConcatenado());
                    }
                    break;

                case 4:
                    System.out.println("Qual o tipo do veículo que gostaria de percorrer?\n(1) - Carro de passeio\t(2) - Caminhão");
                    opcao = scan.nextInt();

                    System.out.println("Escolha um dos veículos para percorrer:");
                    switch (opcao) {
                        case 1:
                            for (int i = 0; i < carros.size(); i++) {
                                System.out.println(i + " - " + carros.get(i).getModelo());
                            }
                            opcao = scan.nextInt();
                            System.out.println("Quilometragem anterior do " + carros.get(opcao).getModelo() + ": " + carros.get(opcao).getQuilometragem() + " km");

                            System.out.println("Quantos quilómetros o carro percorreu?");
                            kmRodados = scan.nextInt();

                            carros.get(opcao).incrementarQuilometragem(kmRodados);
                            linhaHorizontal();
                            carros.get(opcao).percorrer(kmRodados);
                            System.out.println("Nova quilometragem: " + carros.get(opcao).getQuilometragem() + " km");
                            break;

                        case 2:
                            for (int i = 0; i < caminhoes.size(); i++) {
                                System.out.println(i + " - " + caminhoes.get(i).getModelo());
                            }
                            opcao = scan.nextInt();
                            System.out.println("Quilometragem anterior do " + caminhoes.get(opcao).getModelo() + ": " + caminhoes.get(opcao).getQuilometragem() + " km");

                            System.out.println("Quantos quilómetros o caminhão percorreu?");
                            kmRodados = scan.nextInt();

                            caminhoes.get(opcao).incrementarQuilometragem(kmRodados);
                            linhaHorizontal();
                            caminhoes.get(opcao).percorrer(kmRodados);
                            System.out.println("Nova quilometragem: " + caminhoes.get(opcao).getQuilometragem() + " km");
                            break;

                        default:
                            System.out.println("Erro: escolha uma opção válida");
                            break;
                    }
                    opcao = 1;
                    break;

                case 5:
                    System.out.println("\tCarros:");
                    for (int i = 0; i < carros.size(); i++) {
                        System.out.println("\t\t" + carros.get(i).getModelo() + ": " + carros.get(i).getQuilometragem() + " km rodados");
                    }

                    System.out.println("\tCaminhões:");
                    for (int i = 0; i < caminhoes.size(); i++) {
                        System.out.println("\t\t" + caminhoes.get(i).getModelo() + ": " + caminhoes.get(i).getQuilometragem() + " km rodados");
                    }

                    break;

                case 0:
                    System.out.println("Obrigado por usar nosso sistema. Volte sempre!");
                    break;

                default:
                    System.out.println("Erro: selecione uma opção válida");
                    break;
            }
        }
        scan.close();

    }

    public static void linhaHorizontal() {
        System.out.println("\n---==========---\n");
    }
}

