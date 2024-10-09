package joao.maciel.vianna.devmob

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import joao.maciel.vianna.devmob.screen.Chat
import joao.maciel.vianna.devmob.screen.HomeScreen
import joao.maciel.vianna.devmob.screen.Principal
import joao.maciel.vianna.devmob.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    //    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Define o conteúdo da atividade principal, aplicando o tema da aplicação
            MyApplicationTheme {
                // Inicializa o controlador de navegação (NavController), que será responsável por gerenciar a navegação entre as telas
                val navController = rememberNavController()

                // Cria um NavHost para hospedar diferentes rotas (telas) e define a rota inicial como "home"
                NavHost(navController = navController, startDestination = "home") {

                    // Composable para a rota "home". Quando a navegação para "home" for feita,
                    // o Composable HomeScreen será exibido, recebendo o NavController como parâmetro
                    composable("home") { HomeScreen(navController) }

                    // Composable para a rota "principal". Similar ao "home", a tela Principal será exibida
                    // quando a navegação para "principal" for realizada
                    composable("principal") { Principal(navController) }

                    // Composable para a rota "chat" que aceita um parâmetro (userName).
                    // O valor do parâmetro é extraído da rota de navegação
                    composable("chat/{userName}") { backStackEntry ->
                        // Obtém o valor do parâmetro "userName" da rota de navegação
                        val message = backStackEntry.arguments?.getString("userName")

                        // Chama o Composable Chat passando o parâmetro "userName"
                        Chat(userName = message)
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun PMA() {
    MainActivity()
}