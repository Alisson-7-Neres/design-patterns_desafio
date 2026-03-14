# Design Patterns

| Tecnologias  |
 | :-----------  |
 |Java  |
 |Spring boot |
 |Rest Api |
 |Database h2 |
 |Swagger  |


## Singleton:
O Singleton é um padrão de projeto **criacional** que permite a você garantir que uma classe tenha apenas uma instância, enquanto provê um ponto de acesso global para essa instância.
<br>
**Todas as implementações do Singleton tem esses dois passos em comum**:<br>
* Fazer o construtor padrão privado, para prevenir que outros objetos usem o operador new com a classe singleton.<br>
* Criar um método estático de criação que age como um construtor. Esse método chama o construtor privado por debaixo dos panos para criar um objeto e o salva em um campo estático. <br>
* Todas as chamadas seguintes para esse método retornam o objeto em cache.<br>
**Estrutura**
<img src="img/01-singleton.png"/>

## Strategy:
O Strategy é um padrão de projeto **comportamental** que permite que você defina uma família de algoritmos, coloque-os em classes separadas, e faça os objetos deles intercambiáveis.<br>
**Aplicabilidade**:<br>
* Utilize o padrão Strategy quando você quer usar diferentes variantes de um algoritmo dentro de um objeto e ser capaz de trocar de um algoritmo para outro durante a execução.<br>
* Utilize o Strategy quando você tem muitas classes parecidas que somente diferem na forma que elas executam algum comportamento.<br>
* Utilize o padrão para isolar a lógica do negócio de uma classe dos detalhes de implementação de algoritmos que podem não ser tão importantes no contexto da lógica.<br>
* Utilize o padrão quando sua classe tem um operador condicional muito grande que troca entre diferentes variantes do mesmo algoritmo.<br>
**Estrutura**
<img src="img/02-strategy.png">

## Facade:
O Facade é um padrão de projeto **estrutural** que fornece uma interface simplificada para uma biblioteca, um framework, ou qualquer conjunto complexo de classes.<br>
**Aplicabilidade**:<br>
* Utilize o padrão Facade quando você precisa ter uma interface limitada mas simples para um subsistema complexo.<br>
* Utilize o Facade quando você quer estruturar um subsistema em camadas.<br>
**Estrutura**
<img src="img/03-facade.png">

## Spring Framework
Alguns padrões de projetos com Spring:<br>
* **Singleton**: @Bean e @Autowired<br>
* **Strategy**: @Service e @Repository<br>
* **Facade**: Uma API REST
