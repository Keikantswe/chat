import React from 'react'
import img from "../images/logoname.png"

const Message = () => {
  return (
    <div className='Message owner'>
      <div className='MessageInfo'>
        <img src="" alt=''/>
        <span> timehere</span>
      </div>

      <div className='MessageContent'>
        <p> Message contant Sho sho mpinji </p>
        <img src={img} alt=''/>
      </div>
        
    </div>
  )
}

export default Message