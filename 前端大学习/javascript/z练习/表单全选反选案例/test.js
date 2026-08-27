const checkAll = document.querySelector('#checkAll')
const checklist = document.querySelectorAll('#form input[type="checkbox"]')
checkAll.addEventListener('click', function () {
  if (this.checked) {
    for (let i of checklist) {
      i.checked = true
    }
    } else {
    for (let i of checklist) {
      i.checked = false
    }
    }
})

for (let i of checklist){
  i.addEventListener('click', function(){
  let ca = true
  for (let j of checklist){
    if (!(j.checked)) {
      ca = false
      break
    }
  }
  checkAll.checked = ca
})
}
for (let i of checklist) {
  i.addEventListener('click', function () {
    let ca = true
    for (let j of checklist) {
      if (!j.checked) {
        ca = false
        break  // 找到一个未选中的就可以跳出
      }
    }
    checkAll.checked = ca
  })
}