import SwiftUI
import shared

struct ContentView: View {
	let platform = Platform()

	var body: some View {
        ArticleScreen(viewModel: .init())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

/**struct ContentView : View {
    // Define the HTML string here or from a separate data source.
    let htmlContent = """
    <!DOCTYPE html>
    <html>
    <head>
        <title>Redirecting...</title>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    </head>
    <body onload="document.echoForm.submit()">
        <form name="echoForm" method="POST" action="https://demo-ipg.ctdev.comtrust.ae/PaymentEx/PaymentPortal/SendAuth?TransactionID=273676077904" accept-charset="UTF-8">
            <input type="hidden" name="transactionId" value="273676077904">
            <noscript>
                <div id="msg">
                    <div id="submitButton">
                        <input type="submit" value="Continue" class="button">
                    </div>
                </div>
            </noscript>
        </form>
    </body>
    </html>
    """
    
    var body: some View {
        VStack {
            Text("WebView in SwiftUI")
                .font(.largeTitle)
                .padding()

            WebView(htmlString: htmlContent)
                .ignoresSafeArea() // Makes the web view ignore the safe area insets
        }
    }
}**/
