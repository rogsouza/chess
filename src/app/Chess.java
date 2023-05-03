package app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Chess {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList();
		
		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);		
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if (chessMatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine();
					chessMatch.replacePromotedPiece(type);
				}
			} 
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		
	}

}

/*

 Criar repositorio GIT
 ----------------------
 
 1) Ir para diretorio no qual o projeto esta salvo.

	E:\ws\ws_eclipse\Chess
	λ ls -la
	total 6
	drwxr-xr-x 1 radso 197609   0 abr 11 11:30 ./
	drwxr-xr-x 1 radso 197609   0 abr 11 11:30 ../
	-rw-r--r-- 1 radso 197609 396 abr 11 11:30 .classpath
	-rw-r--r-- 1 radso 197609 381 abr 11 11:30 .project
	drwxr-xr-x 1 radso 197609   0 abr 11 11:30 .settings/
	drwxr-xr-x 1 radso 197609   0 abr 11 11:31 bin/
	drwxr-xr-x 1 radso 197609   0 abr 11 11:31 src/
 
2) Inicializar o git no projeto
  
	λ git init
	hint: Using 'master' as the name for the initial branch. This default branch name
	hint: is subject to change. To configure the initial branch name to use in all
	hint: of your new repositories, which will suppress this warning, call:
	hint:
	hint:   git config --global init.defaultBranch <name>
	hint:
	hint: Names commonly chosen instead of 'master' are 'main', 'trunk' and
	hint: 'development'. The just-created branch can be renamed via this command:
	hint:
	hint:   git branch -m <name>
	Initialized empty Git repository in E:/ws/ws_eclipse/Chess/.git/

	λ ls -la
	total 10
	drwxr-xr-x 1 radso 197609   0 abr 11 11:40 ./
	drwxr-xr-x 1 radso 197609   0 abr 11 11:30 ../
	-rw-r--r-- 1 radso 197609 396 abr 11 11:30 .classpath
	drwxr-xr-x 1 radso 197609   0 abr 11 11:40 .git/
	-rw-r--r-- 1 radso 197609 381 abr 11 11:30 .project
	drwxr-xr-x 1 radso 197609   0 abr 11 11:30 .settings/
	drwxr-xr-x 1 radso 197609   0 abr 11 11:31 bin/
	drwxr-xr-x 1 radso 197609   0 abr 11 11:31 src/ 

3) Vincular o git local ao repositorio remoto

	λ git remote add origin git@github.com:rogsouza/chess.git
	
4) Trocar branch de master para main (O git esta criando como main ao inves de master na web)

	λ git branch -m master main

5) Atualizar o repositorio local com os dados do repositorio remoto

	λ git pull origin main
	remote: Enumerating objects: 3, done.
	remote: Counting objects: 100% (3/3), done.
	remote: Compressing objects: 100% (2/2), done.
	remote: Total 3 (delta 0), reused 0 (delta 0), pack-reused 0
	Unpacking objects: 100% (3/3), 780 bytes | 4.00 KiB/s, done.
	From github.com:rogsouza/chess
	 * branch            main       -> FETCH_HEAD
	 * [new branch]      main       -> origin/main

	λ ls -la
	total 15
	drwxr-xr-x 1 radso 197609   0 abr 11 11:52 ./
	drwxr-xr-x 1 radso 197609   0 abr 11 11:30 ../
	-rw-r--r-- 1 radso 197609 396 abr 11 11:30 .classpath
	drwxr-xr-x 1 radso 197609   0 abr 11 11:52 .git/
	-rw-r--r-- 1 radso 197609 301 abr 11 11:52 .gitignore
	-rw-r--r-- 1 radso 197609 381 abr 11 11:30 .project
	drwxr-xr-x 1 radso 197609   0 abr 11 11:30 .settings/
	drwxr-xr-x 1 radso 197609   0 abr 11 11:31 bin/
	drwxr-xr-x 1 radso 197609   0 abr 11 11:31 src/

6) Verificar o status do repositorio local

	λ git status
	On branch main
	Untracked files:
	  (use "git add <file>..." to include in what will be committed)
	        .classpath
	        .project
	        .settings/
	        src/
	
	nothing added to commit but untracked files present (use "git add" to track)

7) Verificar se o usuario corrente esta configurado no git (user.email e user.name) alem de ver como esta configurado a origem (remote.origin.url)

	λ git config --list
	core.symlinks=false
	core.autocrlf=true
	core.fscache=true
	color.interactive=true
	color.ui=auto
	help.format=html
	diff.astextplain.textconv=astextplain
	rebase.autosquash=true
	filter.lfs.clean=git-lfs clean -- %f
	filter.lfs.smudge=git-lfs smudge -- %f
	filter.lfs.process=git-lfs filter-process
	filter.lfs.required=true
	credential.helper=helper-selector
	user.email=radsouza@gmail.com
	user.name=Rogerio Souza
	core.repositoryformatversion=0
	core.filemode=false
	core.bare=false
	core.logallrefupdates=true
	core.symlinks=false
	core.ignorecase=true
	remote.origin.url=git@github.com:rogsouza/chess.git
	remote.origin.fetch=+refs/heads/*:refs/remotes/origin/*
	
8) Setar o usuario e o email

	λ git config --global user.email "radsouza@gmail.com"
	λ git config --global user.name "Rogerio Souza"

9) Adionar os arquivos alterados ao git

	λ git add .
	
10) Realizar o commit

	λ git commit -m "Project created"
	[main a8f02d9] Project created
	 6 files changed, 117 insertions(+)
	 create mode 100644 .classpath
	 create mode 100644 .project
	 create mode 100644 .settings/org.eclipse.core.resources.prefs
	 create mode 100644 .settings/org.eclipse.jdt.core.prefs
	 create mode 100644 src/app/Chess.java
	 create mode 100644 src/module-info.java

11) Enviar as alteracoes para o git remoto

	λ git push -u origin main
	Enumerating objects: 12, done.
	Counting objects: 100% (12/12), done.
	Delta compression using up to 8 threads
	Compressing objects: 100% (10/10), done.
	Writing objects: 100% (11/11), 2.04 KiB | 2.04 MiB/s, done.
	Total 11 (delta 0), reused 0 (delta 0), pack-reused 0
	To github.com:rogsouza/chess.git
	   9d560ce..a8f02d9  main -> main
	branch 'main' set up to track 'origin/main'.
	
12) Atualizar apos algum ajuste

	λ git status
	On branch main
	Your branch is up to date with 'origin/main'.
	
	Changes not staged for commit:
	  (use "git add <file>..." to update what will be committed)
	  (use "git restore <file>..." to discard changes in working directory)
	        modified:   src/app/Chess.java
	
	Untracked files:
	  (use "git add <file>..." to include in what will be committed)
	        src/boardgame/
	
	no changes added to commit (use "git add" and/or "git commit -a")

	---------------------------------------------------------------------------
	E:\ws\ws_eclipse\Chess (main -> origin)
	λ git add .
	
	---------------------------------------------------------------------------
	E:\ws\ws_eclipse\Chess (main -> origin)
	λ git commit -m "First class: Position"
	[main 9a45a1c] First class: Position
	 2 files changed, 137 insertions(+), 3 deletions(-)
	 create mode 100644 src/boardgame/Position.java

	---------------------------------------------------------------------------
	E:\ws\ws_eclipse\Chess (main -> origin)
	λ git push
	Enumerating objects: 11, done.
	Counting objects: 100% (11/11), done.
	Delta compression using up to 8 threads
	Compressing objects: 100% (5/5), done.
	Writing objects: 100% (7/7), 2.45 KiB | 1.22 MiB/s, done.
	Total 7 (delta 1), reused 0 (delta 0), pack-reused 0
	remote: Resolving deltas: 100% (1/1), completed with 1 local object.
	To github.com:rogsouza/chess.git
	   a8f02d9..9a45a1c  main -> main
	
*/