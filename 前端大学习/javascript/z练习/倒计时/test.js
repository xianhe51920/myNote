// 创建指定时间的时间戳
const endTime = +new Date('2026-7-13')
// 获取倒计时对象
const time = document.querySelector('.time')
function loadCutDown(endTime){
  // 获取时间戳之差(单位s)
  const t = parseInt((endTime - +new Date()) / 1000)
  const day = parseInt(t / 60 / 60 / 24)
  const h = parseInt(t / 60 / 60 % 24)
  const m = parseInt(t / 60 % 60)
  const s = parseInt(t % 60)
  return `${day}天${h}时${m}分${s}秒`
}
time.textContent = loadCutDown(endTime)
setInterval(function(){
  time.textContent = loadCutDown(endTime)
}, 1000)