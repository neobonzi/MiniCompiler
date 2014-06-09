void recurse(int a)
{
    if(a > 0)
    {
        printf("%d", a);
        recurse(a - 1);
    }
    return;
}

int main() {
    recurse(5);
}
