import {ReactNode} from "react";
import Image from "next/image";
import Link from "next/link";

export default function DashboardLayout({ children }: { children: ReactNode }) {

    return (
        <>
            <div className="flex h-screen">
                <aside className="w-64 bg-background p-5 border-r border-accent">
                    <Link href={'/dashboard'} className={'inline-flex items-center gap-5'}>
                        <Image src={'/brand/logo-text.png'} width={1584} height={396} className={'w-auto h-12'} alt={'DockerLens Dashboard'} />
                    </Link>
                </aside>
                <main className="flex-1 overflow-auto p-6 bg-background">
                    {children}
                </main>
            </div>
        </>
    )
}