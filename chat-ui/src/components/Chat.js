import React from 'react'
import more from "../images/pngwing.com.png"
import Messages from "./Messages"
import InputMessage from "./InputMessage"

const Chat = () => {
  return (
    <div className='Chat'>
      <div className='ChatInfo'>
        <span> Kelly </span> 
        <img src={more} alt=''/>
      </div>  

      <Messages/>
      <Messages/>
      <Messages/>
      <Messages/>
      <Messages/>
      <InputMessage/>
    </div>
  )
}

export default Chat