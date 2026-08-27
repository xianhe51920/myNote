
// 参考数据
const initData = [
  {
    stuId: 1,
    uname: '迪丽热巴',
    age: 22,
    salary: '12000',
    gender: '女',
    city: '北京',
    time: '2099/9/9 08:08:08'
  }
]
// localStorage.setItem('initData', JSON.stringify(initData))

// 1.1 读取本地数据
const arr = JSON.parse(localStorage.getItem('initData')) || []
// 获取表格标题数目对象
const title = document.querySelector('.title span')
// 获取表格tbody
const tbody = document.querySelector('tbody')
// 获取表单对象
const info = document.querySelector('.info')

// 获取提交按钮
const sm = document.querySelector('.add')

// 初始化渲染
render()

// 添加提交事件监听
info.addEventListener('submit', function (e) {
  e.preventDefault()
  submit()
})

// 渲染模块
function render() {
  // 渲染标题数目
  title.textContent = `${arr.length}`
  // 渲染tbody内容
  // 先清空
  tbody.innerHTML = ''
  for (let i = 0; i < arr.length; i++) {
    //创建行节点
    const tr = document.createElement(`tr`)
    tr.innerHTML = `
    <td>${arr[i].stuId}</td>
    <td>${arr[i].uname}</td>
    <td>${arr[i].age}</td>
    <td>${arr[i].gender}</td>
    <td>${arr[i].salary}</td>
    <td>${arr[i].city}</td>
    <td>${arr[i].time}</td>
    <td>
      <a href="javascript:" data-id="${i}">
        <i class="iconfont icon-shanchu"></i>
        删除
      </a>
    </td>
`
    // 渲染节点
    tbody.appendChild(tr)
  }
}

function submit() {
  // 获取表单需要填写的对象数组
  const name = document.querySelectorAll('.info [name]')
  // 先检查有没有内容为空，把信息添加到数组，再清空表单，再渲染，然后保存
  for (let i of name) {
    if (!i.value) {
      return alert(`输入数据不能为空`)
    }
  }
  // 把信息添加到数组
  arr.push(
    {
      stuId: arr.length ? arr[arr.length - 1].stuId + 1 : 1,
      uname: `${name[0].value}`,
      age: name[1].value,
      salary: `${name[2].value}`,
      gender: `${name[3].value}`,
      city: `${name[4].value}`,
      time: `${new Date().toLocaleString()}`
    }
  )
  // 清空表单
  info.reset()
  // 重新渲染
  render()
  //本地保存
  localStorage.setItem('initData', JSON.stringify(arr))
}


// 删除模块
// 添加删除按钮事件监听
tbody.addEventListener('click', function (e) {
  // 获取按钮id
  if (e.target.tagName === 'A') {
    const i = e.target.dataset.id
    // 删除数组对应元素
    arr.splice(i, 1)
    // 重新渲染
    render()
    // 保存本地
    localStorage.setItem('initData', JSON.stringify(arr))
  }
})