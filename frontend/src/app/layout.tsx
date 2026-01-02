import {ReactNode} from "react";
import "./globals.css"

export default function RootLayout({ children } : { children: ReactNode }) {
    return (
        <html lang="en">
        <body className={'antialiased'}>
        {children}
        </body>
        </html>
    );
}
