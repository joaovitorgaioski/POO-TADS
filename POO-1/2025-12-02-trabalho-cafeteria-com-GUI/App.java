import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        // Frame
        JFrame frame = new JFrame("Cafeteria Bom Jesus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(660, 265, 500, 500);
        frame.setVisible(true);

        JLabel lblTitulo = new JLabel("Bem vindo a Cafeteria Bom Jesus!");
        lblTitulo.setBounds(150, 10, 500, 30);

        JLabel lblSubtitulo = new JLabel("O que deseja fazer?");
        lblSubtitulo.setBounds(150, 30, 500, 30);

        JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
        btnCadastrarCliente.setBounds(150, 100, 200, 30);

        JButton btnRealizarPedido = new JButton("Realizar pedido");
        btnRealizarPedido.setBounds(150, 150, 200, 30);

        JButton btnListarClientes = new JButton("Listar clientes");
        btnListarClientes.setBounds(150, 200, 200, 30);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(150, 250, 200, 30);

        /*
         * Usei listeners com expressões lambda para evitar um pouco de repetição de
         * código
         */

        // Botão de CADASTRO
        btnCadastrarCliente.addActionListener(e -> {
            exibirFormCadastro(clientes);
        });

        // Botão para FAZER PEDIDO
        btnRealizarPedido.addActionListener(e -> {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Não há clientes cadastrados", "Erro",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int opcao = Integer.parseInt(JOptionPane.showInputDialog(frame,
                        "Qual cliente gostaria de realizar o pedido?\n\n" + listarClientes(clientes)));
                int pedido;
                String menu = """
                        1 - Pão R$0.50
                        2 - Coxinha R$4.50
                        3 - Bolo de Chocolate R$5.00
                        4 - Café R$3.00
                        5 - Rissole R$5.00
                        6 - Sonho Pequeno R$1.00
                        0 - FINALIZAR PEDIDO\n
                        """;
                clientes.get(opcao).limparCliente();

                do {
                    pedido = Integer.parseInt(JOptionPane.showInputDialog(frame, menu + clientes.get(opcao).pedidos, "Catálogo", JOptionPane.INFORMATION_MESSAGE));
                    clientes.get(opcao).processarPedido(pedido);
                } while (pedido != 0);

                JOptionPane.showMessageDialog(frame, clientes.get(opcao).obterComanda(), "Comanda",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Botão para LISTAR CLIENTES
        btnListarClientes.addActionListener(e -> {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Não há clientes cadastrados", "Erro",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, listarClientes(clientes), "Lista de clientes cadastrados",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Botão para SAIR
        btnSair.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(lblTitulo);
        frame.add(lblSubtitulo);
        frame.add(btnCadastrarCliente);
        frame.add(btnRealizarPedido);
        frame.add(btnListarClientes);
        frame.add(btnSair);
    }

    // Método pra retornar informações dos clientes
    public static String listarClientes(ArrayList<Cliente> clientes) {
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < clientes.size(); i++) {
            // Exibe as informações do cliente
            lista.append(i).append(" - ").append(clientes.get(i).getNome()).append("  ")
                    .append(clientes.get(i).getTelefone()).append("  ").append(clientes.get(i).getTipoCliente())
                    .append("\n");
        }
        return lista.toString();
    }

    // Método para cadastrar clientes
    public static void exibirFormCadastro(ArrayList<Cliente> clientes) {
        JFrame frameForm = new JFrame("Cadastrando cliente");
        frameForm.setBounds(780, 350, 250, 300);
        frameForm.setVisible(true);
        frameForm.setLayout(null);

        JLabel lblNome = new JLabel("Nome do cliente");
        lblNome.setBounds(50, 0, 150, 30);

        JTextField campoNome = new JTextField();
        campoNome.setBounds(50, 30, 150, 30);

        JLabel lblTelefone = new JLabel("Telefone do cliente");
        lblTelefone.setBounds(50, 60, 150, 30);

        JTextField campoTelefone = new JTextField();
        campoTelefone.setBounds(50, 90, 150, 30);

        JLabel lblFiliado = new JLabel("Filiação do cliente");
        lblFiliado.setBounds(50, 120, 150, 30);

        JRadioButton rbFiliado = new JRadioButton("Filiado");
        rbFiliado.setBounds(50, 150, 150, 25);
        JRadioButton rbNaoFiliado = new JRadioButton("Não filiado");
        rbNaoFiliado.setBounds(50, 180, 150, 25);
        rbNaoFiliado.setSelected(true); // Isso aqui define o padrão

        ButtonGroup grupoFiliacao = new ButtonGroup();
        grupoFiliacao.add(rbFiliado);
        grupoFiliacao.add(rbNaoFiliado);

        JButton btnCadastrar = new JButton("Cadastrar cliente");
        btnCadastrar.setBounds(50, 210, 150, 30);

        frameForm.add(lblNome);
        frameForm.add(campoNome);
        frameForm.add(lblTelefone);
        frameForm.add(campoTelefone);
        frameForm.add(lblFiliado);
        frameForm.add(rbFiliado);
        frameForm.add(rbNaoFiliado);
        frameForm.add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            if (campoNome.getText().isEmpty() || campoTelefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frameForm, "Nome e telefone são obrigatórios.", "Erro",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (rbFiliado.isSelected()) {
                clientes.add(new ClienteFiliado());
            } else {
                clientes.add(new ClienteNaoFiliado());
            }
            clientes.get(clientes.size() - 1).realizarCadastro(campoNome.getText(), campoTelefone.getText());

            JOptionPane.showMessageDialog(frameForm, "Cliente " + campoNome.getText() + " cadastrado com sucesso!");
            frameForm.dispose();
        });
    }
}