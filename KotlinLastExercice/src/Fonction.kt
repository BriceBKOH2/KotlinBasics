class ObjectManager {
        companion object create {
            fun customer(name: String, city: City, vararg orders: Order) = Customer(name,city, orders.toList())
            fun order(vararg products: Product, isDelivered: Boolean = true) = Order(products.toList(),isDelivered)
            fun shop(name: String, vararg customers: Customer) = Shop(name,customers.toList())
        }
}

// Produit
val prodCaisseFraises = Product("caisse de fraises",10.5)
val prodCourgette = Product("courgette", 1.2)
val prodBoiteCancer = Product("paquet de cigarette", 50.0)
val prodSextoyVeget = Product( "aubergine", 2.1)
val prodDrogueEnfant = Product("sachet de bonbons", 2.3)
val prodEsclavagismeAlimentaire = Product("tablette de chocolat",8.53)

// Order
val orderClassique = ObjectManager.order(prodCaisseFraises,prodCourgette,prodDrogueEnfant,isDelivered = false)
val orderMenagere = ObjectManager.order(prodDrogueEnfant,prodCourgette,prodSextoyVeget)
val orderRoutier = ObjectManager.order(prodDrogueEnfant,prodSextoyVeget,prodBoiteCancer,prodEsclavagismeAlimentaire)

// City
val cityMontpel = City("Montpellier")
val cityParis = City("Paris")
val cityPaumé = City("St-Georgette-En-Culbute")
val cityAvecPerson = City("Mon-Cul")

// Customer
val customer1 = ObjectManager.customer("Jean-Pipou",cityPaumé,orderClassique)
val customer2 = ObjectManager.customer("Estellade",cityMontpel,orderMenagere)
val customer3 = ObjectManager.customer("Bobby l'acheteur compulsif",cityParis,orderClassique,orderRoutier,
    ObjectManager.order(prodSextoyVeget),ObjectManager.order(prodSextoyVeget))

// Shop
val shopLocal = ObjectManager.shop("Chez georgette",customer1,customer3)
val shopInternet = ObjectManager.shop("Ikealimentaire",customer2,customer3)
val shopInternetParis = ObjectManager.shop("Ikealim mais pour snoob",customer3,customer3)



// Fonction
    // Shop
fun Shop.getSetofCustomer() = this.customers.toSet()
fun Shop.getCitiesCustomersAreFrom() = customers.map { it.city }.toSet()
fun Shop.getCustomersFrom(city: City) = customers.filter { it.city == city  }
fun Shop.checkAllCustomersAreFrom(city: City) = customers.count { it.city == city } == customers.size
fun Shop.hasCustomerFrom(city: City) = customers.find { it.city == city } != null
fun Shop.countCustomersFrom(city: City) = customers.count { it.city == city }
fun Shop.findAnyCustomerFrom(city: City) = customers.find { it.city == city }
val Shop.allOrderedProducts: Set<Product> get() = this.customers.flatMap { it.orderedProducts }.toSet()
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = this.customers.maxBy { it.orders.size }
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = this.customers.sortedBy { it.orders.size }
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = this.customers.groupBy { it.city }
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = this.customers.filter { it.orders.count {order ->  !order.isDelivered } > it.orders.count { order -> order.isDelivered } }.toSet()
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> = this.customers.flatMap { it.orderedProducts }.toSet()
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int = this.customers.flatMap { it.getOrderedProductsList() }.count{it == product}

    // Customer
val Customer.orderedProducts: Set<Product> get() = this.orders.flatMap { it.products }.toSet()
fun Customer.getMostExpensiveOrderedProduct(): Product? = this.orderedProducts.maxBy { it.price }
fun Customer.getTotalOrderPrice(): Double = this.orderedProducts.sumByDouble { it.price }
fun Customer.getMostExpensiveDeliveredProduct(): Product? = this.orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
fun Customer.getOrderedProductsList(): List<Product> = this.orders.flatMap { it.products }
