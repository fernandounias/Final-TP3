import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.LocalColors
import com.example.parcial.ui.theme.DarkPurple
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun VisualizadorSaldo(
    modifier: Modifier = Modifier,
    texto: String,
    saldo: Number,
    textoSize: Int = 32,
    saldoSize: Int = 12,
) {
    val symbols = DecimalFormatSymbols(Locale.getDefault()).apply {
        decimalSeparator = ','
        groupingSeparator = '.'
    }
    val decimalFormat = DecimalFormat("#,##0.00", symbols)
    val formattedSaldo = "$ ${decimalFormat.format(saldo)}"
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )

    Column(
        modifier = modifier
            .widthIn(min = 153.dp)
            .heightIn(min = 53.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = texto,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontFamily = manropeBold,
                color = LocalColors.current.textTitles,
                fontSize = saldoSize.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 14.4.sp,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = formattedSaldo,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontFamily = manropeBold,
                color = LocalColors.current.textTitles,
                fontSize = textoSize.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 35.2.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun VisualizadorSaldoPreview() {
    VisualizadorSaldo(
        texto = stringResource(id = R.string.acc_balance),
        saldo = 12345.67,
        textoSize = 32,
        saldoSize = 12
    )
}