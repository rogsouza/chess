package app;

public class Chess {

	public static void main(String[] args) {

		System.out.println("Hello World!");

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

3) Vincular o git ao repositorio remoto

	λ git remote add origin git@github.com:rogsouza/chess.git
	
4) Trocar master para main

	

*/