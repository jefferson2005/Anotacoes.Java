function carregarDetalhes(){
    let lstdetalhepedido = document.getElementById("lstDetalhePedido");
    let dados = "";


  fetch("http://localhost:5000/api/v1/detalhepedido/listar")
  .then((response) => response.json())
  .then((rs) =>{
    console.log(rs);
    rs.map((itens, ix) =>{
        dados += `<ul id="detalhepedido">
                    <li>${itens.iddetalhepedido}</li>
                    <li>${itens.quantidade}</li>
                    <li>${itens.precounitario}</li>
                    <li>${itens.valortotal}</li>
        </ul> `;
     lstdetalhepedido.innerHTML += dados;
    });
  })
.catch((err)=>console.error(err));
}