window.addEventListener('scroll', function(){
  let scrollTop = document.documentElement.scrollTop
  let c = document.querySelector('.seckill').offsetTop
  console.log(c, scrollTop)
  if(c <= scrollTop){
    document.querySelector('nav').style.top = '0px'
  } else {
    document.querySelector('nav').style.top = '-100px'
  }
})