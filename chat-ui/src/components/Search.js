import React from 'react'


const Search = () => {
  return (
    <div className='Search'>
      <div className='SearchedUser'>
        <input type='text' placeholder='Search User'/>
      </div>   

      <div className='FoundUser'>
        <img src='https://www.google.com/imgres?imgurl=https%3A%2F%2Fraw.githubusercontent.com%2FDXHeroes%2Fknowledge-base-content%2Fmaster%2Ffiles%2Fsolid.jpg&tbnid=-FQhMvdhJvAJ9M&vet=12ahUKEwjDrMb1_P-CAxWUfqQEHZHgC2YQMygEegQIARB7..i&imgrefurl=https%3A%2F%2Fdeveloperexperience.io%2Farticles%2Fsolid&docid=aqkoSrNnK2_b6M&w=1280&h=720&q=solid%20principles&ved=2ahUKEwjDrMb1_P-CAxWUfqQEHZHgC2YQMygEegQIARB7' alt=''/>
        <div className='FoundUserDetails'>
          <span> Rama </span>
        </div>
        
      </div>
    </div>
  )
}

export default Search