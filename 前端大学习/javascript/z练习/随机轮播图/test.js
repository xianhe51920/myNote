// 路径列表
const imgList = [
  './img/h1.jpg',
  './img/h2.jpg',
  './img/h3.jpg',
  './img/h4.jpg',
  './img/h5.jpg',
  './img/h6.jpg',
  './img/h7.jpg',
]
// 描述列表
const descList = [
  '纳西妲1',
  '纳西妲2',
  '纳西妲3',
  '纳西妲4',
  '纳西妲5',
  '纳西妲6',
  '纳西妲7',
]

// 获取图片对象
const pic = document.querySelector('.img-box img')
// 获取描述对象
const des = document.querySelector('.bottom .left figcaption')
// 获取按钮对象列表
const dot = document.querySelectorAll('.dot-box span')
const right = document.querySelector('.right')
const lt = document.querySelectorAll('.right .lt')
const gt = document.querySelectorAll('.right .gt')

// 轮播
let x = 0 //轮播图变量
const swi = setInterval(function(){
  x++
  if (x === dot.length){x = 0}
  //修改图片
  pic.src = imgList[x]
  //修改描述
  des.innerHTML = descList[x]
  //修改圆点
  for(let i = 0; i < dot.length; i++){
    dot[i].classList.remove('focus')
  }
  dot[x].classList.add('focus')
},1000)

//鼠标停留离开事件
//鼠标停留在画面上，轮播图停止
pic.addEventListener('mouseenter', function(){
  clearInterval(swi)
})
// 鼠标离开画面，轮播图继续


//鼠标悬停轮播按钮，轮播图暂停
right.addEventListener('mouseenter', function(){
  clearInterval(swi)
})
lt.addEventListener('mouseenter', function(){
  clearInterval(swi)
})
gt.addEventListener('mouseenter', function(){
  clearInterval(swi)
})