function logar(){
    const us = document.getElementById("login");
    const sh = document.getElementById("senha");
    const btn = document.getElementById("btnlogar");

    fetch("http://localhost:5000/api/v1/usuario/login",{
        method: "POST",
        headers:{
            accept:"application/json",
            contentType:"application/json"
        },
        body: JSON.stringify({
            login:us.value,
            senha:sh.value
        })
    })
    .then((response)=>response.json())
    .then((dt)=>{
        alert("Bem Vindo");
    })
    .catch((err)=> console.error(err));
    
}

function cadastrar(){
    const us = document.getElementById("login");
    const sh = document.getElementById("senha");
    const co = document.getElementById("confirmar")
    const na = cocument.getElementById("nivel")

    if(sh.value = co.value){
        return alert("As senhas não são iguais");
     }else{
        fetch("http://localhost:5000/api/v1/usuario/cadastro",{
            headers:{
                accept:"application/json",
                contentType:"application/json"
            },
            body: JSON.stringify({
                login:login.value,
                senha:senha.value,
                nivelacesso:nivel.value
            })
        })
     }
}
