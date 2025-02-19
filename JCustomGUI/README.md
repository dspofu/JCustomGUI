# JCustomGUI
## Estrutura base do `JCustomGUI`

> Explicações dos metodos

- [JFrameBuilder](#usando-o-jframebuilder)
- [JLabelBuilder](#usando-o-jlabelbuilder)

<details open>
  <summary style="font-size: 16px"><strong>Conteudo explicativo dos metodos anexados aos topicos acima</strong></summary>

### Usando o `JFrameBuilder`
> Tabela das propriedades e seus tipos

|Method|Type|Usage|Default|Required|
|---|:---:|---|:---:|:---:|
|__title__|String|"My Window title"|-|__[ x ]__|
|__size__|int`x2`|(400, 200)|-|__[ ✓ ]__|
|__background__|`Color`|(Color.GRAY)|white|__[ x ]__|
|__resizable__|boolean|(`true` or `false`)|false|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ x ]__|
|__closeOperation__|int|(JFrame.EXIT_ON_CLOSE)|3|__[ x ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JFrame frame = new JFrameBuilder() // Chamando a classe personalizada
  .title("My Window") // Adicionado um nome a sua janela
  .size(400, 600) // Tamanho da janela que vai ser criada
  .background(Color.darkGray) // Alterando a cor de fundo padrão
  .resizable(true) // Tornando a janela redimencionavel
  .location() // Fazendo com que a janela inicie centralizada
  .build(); // Coleta todas as informações inseridas e aplica

frame.setVisible(true); // Exibir a janela
```

### Usando o `JLabelBuilder`
> Tabela das propriedades e seus tipos

|Method|Type|Usage|Default|Required|
|---|:---:|:---|:---:|:---:|
|__content__|String|"Some text"|-|__[ x ]__|
|__background__|`Color`, `Integer`|(Color.GRAY, 10)|-|__[ x ]__|
|__foreground__|`Color`|(Color.GRAY)|gray|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ ✓ ]__|
|__font__|`Font`, int|new Font(Font.SERIF, Font.BOLD, 30)|SANS_SERIF, Font.BOLD, 20|__[ x ]__|
|__build__|void|( )|-|__[ ✓ ]__|

```java
JLabel text = new JLabelBuilder()
  .content("Login") // Texto a ser exibido
  .background(Color.GRAY, 10) // Adiciona uma cor de fundo e o arredondamento da borda
  .foreground(Color.GRAY) // Alterando a cor do texto
  .location(150, 5) // O elemento inicia a 140px de largura e 20px de altura de acordo com o janela
  .font(new Font(Font.MONOSPACED, Font.BOLD, 30)) // Fonte monospace, estilo bold, tamanho 30
  .build(); // Coleta todas as informações inseridas e aplica

frame.add(text); // Exibir na sua janela anteriormente criada
```
</details>
