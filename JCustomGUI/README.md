# JCustomGUI
## Estrutura base do `JCustomGUI`

> Explicações dos metodos

[JFrameBuilder](#usando-o-jframebuilder)

<!-- <details>
  <summary>Conteudo explicativo</summary> -->

### Usando o `JFrameBuilder`
> Tabela das propriedades e seus tipos

|Method|Type|Usage|Default|Required|
|---|:---:|---|:---:|:---:|
|__title__|string|"My Window title"|-|__[ x ]__|
|__size__|int`x2`|(400, 200)|-|__[ ✓ ]__|
|__background__|`Color`|(Color.GRAY)|white|__[ x ]__|
|__resizable__|boolean|(`true` or `false`)|false|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ x ]__|
|__closeOperation__|int|(JFrame.EXIT_ON_CLOSE)|3|__[ x ]__|
|__build__|-|- |-|__[ ✓ ]__|

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
|__content__|string|"My text"|-|__[ x ]__|
|__size__|int|50|20|__[ x ]__|
|__background__|`Color`|(Color.GRAY)|-|__[ x ]__|
|__foreground__|`Color`|(Color.GRAY)|gray|__[ x ]__|
|__location__|int`x2`|(50, 50)|-|__[ ✓ ]__|
|__font__|Font|new Font(Font.SERIF, Font.BOLD, 10)|SANS_SERIF, Font.BOLD|__[ x ]__|
|__build__|-|- |-|__[ ✓ ]__|

```java
JLabel text = new JLabelBuilder()
  .content("Login") // Texto a ser exibido
  .foreground(Color.GRAY) // Alterando a cor do texto
  .background(Color.darkGray) // Alterando a cor de fundo padrão
  .size(50) // Tamanho do texto a ser exibido
  .location(120, 5) // O elemento inicia a 140px de largura e 20px de altura de acordo com o janela
  .build(); // Coleta todas as informações inseridas e aplica

frame.add(text); // Exibir na sua janela anteriormente criada
```
<!-- </details> -->
