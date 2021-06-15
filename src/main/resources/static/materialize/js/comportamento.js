/**
 * 
 */
function abrirNav(){
	document.getElementById("menuOculto").style.width="";
	document.getElementById("principal").style.marginLeft="";
	
}
function fecharNav(){
	document.getElementById("menuOculto").style.width="0px";
	document.getElementById("principal").style.marginLeft="0px";
	
}
cadastroAluno.addEventListener('click', function (){
	if(formcadastroAluno.style.display === 'block'){
		formcadastroAluno.style.display = 'none';
	}else {
		formcadastroAluno.style.display = 'block';
	}
});

cadastroTreino.addEventListener('click', function (){
	if(formcadastroTreino.style.display === 'block'){
		formcadastroTreino.style.display = 'none';
	}else {
		formcadastroTreino.style.display = 'block';
	}
});

buscarAluno.addEventListener('click', function (){
	if(formbuscarAluno.style.display === 'block'){
		formbuscarAluno.style.display = 'none';
	}else {
		formbuscarAluno.style.display = 'block';
	}
});

buscarTreino.addEventListener('click', function (){
	if(formbuscarTreino.style.display === 'block'){
		formbuscarTreino.style.display = 'none';
	}else {
		formbuscarTreino.style.display = 'block';
	}
});