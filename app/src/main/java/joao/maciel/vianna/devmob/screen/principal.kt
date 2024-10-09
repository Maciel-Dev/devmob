package joao.maciel.vianna.devmob.screen

// Importações necessárias para os componentes de UI do Jetpack Compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import joao.maciel.vianna.devmob.R

// Função composable que cria a tela Principal, onde se exibe a lista de amigos online
@Composable
fun Principal(navController: NavController) {
    // Lista temporária de usuários online
    val usersTemp = listOf("Joao", "Marcos", "ABC")

    // Surface é um contêiner básico que define a estrutura da UI
    Surface {
        // Coluna para organizar os componentes verticalmente
        Column(
            modifier = Modifier.fillMaxSize(), // A Coluna ocupa toda a tela
            verticalArrangement = Arrangement.Top, // Organização dos elementos de cima para baixo
            horizontalAlignment = Alignment.CenterHorizontally // Alinhamento horizontal centralizado
        ) {
            // Linha para o cabeçalho (logo do MSN, status, e informações do usuário)
            Row(
                modifier = Modifier.fillMaxWidth(), // A linha ocupa toda a largura da tela
                verticalAlignment = Alignment.CenterVertically, // Alinhamento vertical centralizado
                horizontalArrangement = Arrangement.Start // Os componentes são organizados a partir do início
            ) {
                // Coluna que contém o logo do MSN e o status do usuário
                Column(
                    verticalArrangement = Arrangement.Center, // Elementos centralizados verticalmente
                    horizontalAlignment = Alignment.CenterHorizontally, // Alinhamento horizontal centralizado
                    modifier = Modifier.padding(8.dp) // Adicionar espaçamento externo de 8dp
                ) {
                    // Cartão que envolve o logo do MSN
                    Card(
                        modifier = Modifier
                            .size(70.dp) // Tamanho do cartão 70dp
                            .padding(8.dp) // Espaçamento de 8dp ao redor do cartão
                    ) {
                        // Imagem do logo do MSN
                        Image(
                            painter = painterResource(id = R.drawable.msn_logo), // Recurso de imagem do logo
                            modifier = Modifier
                                .fillMaxSize() // A imagem preenche o tamanho máximo do cartão
                                .padding(2.dp) // Adiciona um padding interno de 2dp
                                .clip(RoundedCornerShape(10.dp)), // Imagem com bordas arredondadas
                            contentDescription = "MSN Logo", // Descrição da imagem
                            contentScale = ContentScale.Fit // Escalar a imagem para caber no espaço sem ser cortada
                        )
                    }
                    // Texto que exibe o status do usuário
                    Text(text = "Status: Not for you", style = TextStyle(fontSize = 10.sp)) // Texto de status
                }
                // Coluna ao lado do logo para exibir informações do usuário
                Column(
                    verticalArrangement = Arrangement.Center, // Centralizado verticalmente
                    horizontalAlignment = Alignment.Start // Alinhamento à esquerda
                ) {
                    // Texto que exibe o nome e o status online
                    Text(
                        text = "João Maciel (online)", // Nome do usuário com o status
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp) // Texto negrito, tamanho 14sp
                    )
                    // Texto adicional para atividades ou status
                    Text(
                        text = "Activity", // Texto de atividade
                        style = TextStyle(fontSize = 12.sp), // Tamanho do texto 12sp
                        textAlign = TextAlign.Start // Alinhamento do texto à esquerda
                    )
                }
                // Outra linha para exibir mensagens ao lado direito do cabeçalho
                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Ocupa toda a largura restante da tela
                        .padding(10.dp), // Adiciona padding externo de 10dp
                    verticalAlignment = Alignment.CenterVertically, // Alinhamento vertical centralizado
                    horizontalArrangement = Arrangement.End // Alinhamento do conteúdo ao fim (direita)
                ) {
                    // Texto que informa sobre mensagens não lidas
                    Text(text = "No new Messages", style = TextStyle(fontSize = 10.sp)) // Texto de mensagens
                }
            }
            // Coluna para exibir a lista de amigos online
            Column(
                modifier = Modifier
                    .fillMaxSize() // Ocupa toda a área restante da tela
                    .padding(8.dp) // Adiciona padding de 8dp
                    .fillMaxSize(), // Ocupar a área restante
                verticalArrangement = Arrangement.Top, // Organiza os elementos de cima para baixo
                horizontalAlignment = Alignment.Start // Alinhamento à esquerda
            ) {
                // Texto que exibe o número de amigos online
                Text(
                    text = "Online Friends (${usersTemp.size})", // Exibe a quantidade de amigos online
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp) // Texto em negrito e tamanho 14sp
                )
                // Itera pela lista temporária de amigos e cria um componente Row para cada um
                usersTemp.forEach { user ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth() // A linha ocupa toda a largura
                            .padding(10.dp) // Adiciona padding de 10dp ao redor de cada item
                            .clickable(onClick = { navController.navigate("chat/${user}") }), // Ação de navegação ao clicar
                        verticalAlignment = Alignment.CenterVertically, // Centralizado verticalmente
                        horizontalArrangement = Arrangement.Start // Alinhado ao início (esquerda)
                    ) {
                        // Imagem do ícone do usuário
                        Image(
                            painter = painterResource(id = R.drawable.msn_icon_user), // Ícone do usuário
                            contentDescription = "User icon", // Descrição da imagem
                            modifier = Modifier.fillMaxSize(0.06f) // A imagem ocupa 6% da largura da tela
                        )
                        // Espaço entre o ícone e o texto do nome do usuário
                        Spacer(modifier = Modifier.width(10.dp)) // Espaçamento de 10dp
                        // Texto que exibe o nome do usuário
                        Text(
                            text = user, // Nome do usuário
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold), // Texto em negrito, tamanho 12sp
                            textAlign = TextAlign.Center // Alinhamento do texto centralizado
                        )
                    }
                }
            }
        }
    }
}

// Função para visualizar a tela no editor (preview)
@Composable
@Preview
fun PP() {
    val navController = rememberNavController() // Cria um NavController para navegação
    Principal(navController) // Exibe a função Principal no preview
}
