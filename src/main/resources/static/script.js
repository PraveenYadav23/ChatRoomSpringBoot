var stompClient=null

function sendMessage(){
  let jsonOb={
   name:localStorage.getItem("name"),
   content:$("#message-value").val()
  }
  stompClient.send("/app/chat",{},JSON.stringify(jsonOb));
}


function connect(){
  let socket=new SockJS("/chat")
  stompClient=Stomp.over(socket)
  stompClient.connect({},function(frame){
      console.log("Connected : "+frame)
      $("#name-form").addClass('d-none')
      $("#chat-room").removeClass('d-none')

      //subscribe
      stompClient.subscribe("/topic/messages",function(response){
        showMessage(JSON.parse(response.body))
      })
  })
}

function disconnect() {
  localStorage.removeItem("name")
  if(stompClient!==null)
  {
    stompClient.disconnect()
    $("#name-form").removeClass('d-none')
    $("#chat-room").addClass('d-none')
    console.log(stompClient)
  }
  console.log("Disconnected");
}

function showMessage(message){
    $("#message-container-table").prepend(`<tr><td><b>${message.name} :</b> ${message.content} <sub>${message.time}<sub></td></tr>`)
    document. getElementById('message-value'). value = ""
 }

$(document).ready((e)=>{
  $("#login").click(()=>{
      let name=$("#name-value").val()
      localStorage.setItem("name",name)
      $("#name-title").html(`Welcome , <b>${name} </b>`)
      connect();
   })

   $("#send-btn").click(()=>{
    sendMessage()
   })

$("#logout").click(()=>{

    localStorage.removeItem("name")
    if(stompClient!==null)
    {
        stompClient.disconnect()

         $("#name-form").removeClass('d-none')
         $("#chat-room").addClass('d-none')
         console.log(stompClient)
    }

})

})