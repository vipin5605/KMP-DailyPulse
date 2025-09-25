//
//  WebView.swift
//  iosApp
//
//  Created by Vipin Vasu on 16/09/2025.
//  Copyright © 2025 orgName. All rights reserved.
//


import SwiftUI
import WebKit

struct WebView: UIViewRepresentable {
    // The HTML content to load
    let htmlString: String
    
    // Create a Coordinator class to handle WKNavigationDelegate callbacks.
    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }

    // Creates the WKWebView view object and sets up the Coordinator.
    func makeUIView(context: Context) -> WKWebView {
        let webView = WKWebView()
        webView.navigationDelegate = context.coordinator
        return webView
    }

    // Updates the WKWebView with the new HTML content when SwiftUI state changes.
    func updateUIView(_ uiView: WKWebView, context: Context) {
        uiView.loadHTMLString(htmlString, baseURL: nil)
    }

    // The Coordinator class acts as the WKWebView's delegate.
    class Coordinator: NSObject, WKNavigationDelegate {
        var parent: WebView
        
        init(_ parent: WebView) {
            self.parent = parent
        }

        // Handles the SSL authentication challenge.
        func webView(_ webView: WKWebView, didReceive challenge: URLAuthenticationChallenge, completionHandler: @escaping (URLSession.AuthChallengeDisposition, URLCredential?) -> Void) {
            // **WARNING:** This code bypasses certificate validation and is insecure.
            // It is only for testing with self-signed or invalid certificates.
            // DO NOT USE IN PRODUCTION.
            if challenge.protectionSpace.authenticationMethod == NSURLAuthenticationMethodServerTrust {
                guard let serverTrust = challenge.protectionSpace.serverTrust else {
                    completionHandler(.cancelAuthenticationChallenge, nil)
                    return
                }
                let credential = URLCredential(trust: serverTrust)
                completionHandler(.useCredential, credential)
            } else {
                completionHandler(.performDefaultHandling, nil)
            }
        }
        
        // Optional: Implement other delegate methods for debugging.
        func webView(_ webView: WKWebView, didFail navigation: WKNavigation!, withError error: Error) {
            print("Navigation failed with error: \(error.localizedDescription)")
        }
        
        func webView(_ webView: WKWebView, didFailProvisionalNavigation navigation: WKNavigation!, withError error: Error) {
            print("Provisional navigation failed with error: \(error.localizedDescription)")
        }
        
    }
}
