#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* ================= 链栈类型定义（带头节点） ================= */
typedef struct StackNode {
    int data;               // 结点数据域
    struct StackNode *next; // 结点指针域
} StackNode, *LinkStack;

/* ================= 基本操作函数 ================= */

// 初始化空栈：建立头节点，其 next 置空
int InitStack(LinkStack *ls) {
    *ls = (StackNode *) malloc(sizeof(StackNode));
    if (*ls == NULL) {      // 头节点分配失败
        return 0;
    }
    (*ls)->next = NULL;
    return 1;
}

// 判空：头节点的 next 为空即栈空，返回 1
int StackEmpty(LinkStack ls) {
    return ls->next == NULL;
}

// 入栈：在头节点之后插入新结点，e 为入栈元素，成功返回 1
int Push(LinkStack ls, int e) {
    StackNode *p = (StackNode *) malloc(sizeof(StackNode));
    if (p == NULL) {        // 内存分配失败
        return 0;
    }
    p->data = e;
    p->next = ls->next;     // 新结点指向原栈顶结点
    ls->next = p;           // 头节点指向新结点，使其成为栈顶
    return 1;
}

// 出栈：删除头节点后的首个结点，用 e 带回栈顶元素值
// 成功返回 1；栈空（下溢）返回 0
int Pop(LinkStack ls, int *e) {
    if (StackEmpty(ls)) {   // 下溢判断
        return 0;
    }
    StackNode *p = ls->next;
    *e = p->data;           // 保存栈顶元素值
    ls->next = p->next;     // 头节点指向下一个结点
    free(p);                // 释放原栈顶结点
    return 1;
}

// 取栈顶元素：不修改栈，仅用 e 带回栈顶元素值
// 成功返回 1；栈空返回 0
int GetTop(LinkStack ls, int *e) {
    if (StackEmpty(ls)) {
        return 0;
    }
    *e = ls->next->data;    // 栈顶是头节点的下一个结点
    return 1;
}

// 销毁栈：连同头节点一起释放，避免内存泄漏
void DestroyStack(LinkStack *ls) {
    StackNode *p = *ls;
    while (p != NULL) {
        StackNode *q = p;
        p = p->next;
        free(q);
    }
    *ls = NULL;
}

/* ================= 实验功能封装 ================= */

// 随机产生 10 个 100 以内的整数并依次入栈，打印入栈序列
void PushRandom(LinkStack ls) {
    printf("---- 依次入栈 10 个 100 以内的随机整数 ----\n");
    printf("入栈顺序: ");
    for (int i = 0; i < 10; i++) {
        int e = rand() % 100; // [0, 99]
        Push(ls, e);
        printf("%d ", e);
    }
    printf("\n");
}

// 从键盘输入出栈元素个数 n（n<10），将 n 个元素出栈并显示，考虑下溢
void PopN(LinkStack ls) {
    int n;
    printf("请输入出栈元素个数 n (n<10): ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("输入无效，无元素出栈。\n");
        return;
    }

    printf("出栈顺序: ");
    for (int i = 0; i < n; i++) {
        int e;
        if (Pop(ls, &e)) {          // Pop 内部完成下溢判断
            printf("%d ", e);
        } else {
            printf("\n栈已空，发生下溢，停止出栈！");
            break;
        }
    }
    printf("\n");
}

// 取栈顶元素并显示，若栈空则提示
void ShowTop(LinkStack ls) {
    int e;
    if (GetTop(ls, &e)) {
        printf("当前栈顶元素为: %d\n", e);
    } else {
        printf("栈空，无法取栈顶元素！\n");
    }
}

/* ================= 主函数 ================= */
int main() {
    LinkStack ls;        // 指向头节点的栈指针
    if (!InitStack(&ls)) { // 建立带头节点的空栈
        printf("栈初始化失败！\n");
        return 1;
    }

    srand((unsigned) time(NULL)); // 以当前时间作为随机数种子

    PushRandom(ls);  // 1. 入栈操作
    PopN(ls);        // 2. 出栈操作（含下溢判断）
    ShowTop(ls);     // 3. 取栈顶元素操作

    DestroyStack(&ls); // 释放栈内存（含头节点）
    return 0;
}
