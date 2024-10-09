package joao.maciel.vianna.devmob.screen

// Importações necessárias para os componentes de UI do Jetpack Compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import joao.maciel.vianna.devmob.R

// Função Composable para a tela de chat, recebendo o nome do usuário como parâmetro
@Composable
fun Chat(userName: String?) {

    // Definição de algumas cores usadas na interface
    val LightBlue = Color(0xFFB0D9F5) // Azul claro para o cabeçalho
    val DarkBlue = Color(0xFF3993DD)   // Azul escuro para botões e abas
    val White = Color(0xFFFFFFFF)      // Branco para o fundo
    val LightGray = Color(0xFFE5E5E5)  // Cinza claro para caixas de texto e bordas
    val Green = Color(0xFF8DD696)      // Verde para ícones de disponibilidade
    val Yellow = Color(0xFFFFCC33)     // Amarelo para ícones de status

    // Criação de um brush de gradiente linear que será usado como fundo para o cabeçalho
    val BlueGradientBrush = Brush.linearGradient(
        colors = listOf(LightBlue, DarkBlue),
        start = Offset(0f, 0f),
        end = Offset(1000f, 1000f)
    )

    // Estrutura principal da UI: Coluna que ocupa toda a tela
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupar toda a área disponível
            .background(Color.White), // Definir fundo branco
        verticalArrangement = Arrangement.Top, // Organizar os elementos do topo para baixo
        horizontalAlignment = Alignment.CenterHorizontally // Alinhar horizontalmente no centro
    ) {

        // Linha para o cabeçalho, contendo a imagem do usuário e o nome
        Row(
            modifier = Modifier
                .fillMaxWidth() // Ocupar toda a largura da tela
                .height(100.dp) // Definir uma altura de 100dp
                .background(brush = BlueGradientBrush), // Aplicar o gradiente de azul como fundo
            verticalAlignment = Alignment.CenterVertically, // Alinhar o conteúdo verticalmente no centro
            horizontalArrangement = Arrangement.Start // Organizar os elementos do início da linha
        ) {

            // Card que contém a imagem do usuário
            Card(
                modifier = Modifier.padding(10.dp), // Adicionar um espaçamento de 10dp ao redor do card
                colors = CardDefaults.cardColors(containerColor = Color(0xFF3993DD)) // Definir a cor de fundo do card como azul escuro
            ) {
                // Imagem do usuário dentro do Card
                Image(
                    painter = painterResource(id = R.drawable.duck_image), // Carregar imagem a partir dos recursos
                    contentDescription = "User Image", // Descrição da imagem para acessibilidade
                    modifier = Modifier
                        .height(80.dp) // Definir a altura da imagem como 80dp
                        .padding(6.dp) // Adicionar espaçamento interno de 6dp
                        .clip(RoundedCornerShape(8.dp)), // Aplicar cantos arredondados à imagem
                    contentScale = ContentScale.Inside // Escalar a imagem para caber dentro do espaço sem cortar
                )
            }

            // Coluna ao lado da imagem para exibir o nome do usuário
            Column {
                // Exibição do nome do usuário como texto
                Text(
                    text = "$userName", // Exibir o nome do usuário passado como argumento
                    modifier = Modifier.padding(8.dp), // Adicionar um espaçamento de 8dp ao redor do texto
                    color = Color.White, // Definir a cor do texto como branco
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp) // Estilo do texto com fonte negrito e tamanho 20sp
                )
            }
        }
    }
}

// Função para visualização da tela de chat no editor (preview)
@Composable
@Preview
fun ChatPreview() {
    Chat(userName = "Joao") // Pré-visualização da tela com o nome "Joao"
}
