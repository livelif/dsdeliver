
import { useIsFocused, useNavigation } from '@react-navigation/native';
import React, { useEffect, useState } from 'react';
import { StyleSheet, ScrollView, Alert, Text } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { fetchOrders } from '../api';
import Header from '../Header';
import OrderCard from '../OrderCard';
import { Order } from '../types';

export default function Orders() {

    const [orders, setOrders] = useState<Order[]>([]);
    const [isLoading, setIsLoading] = useState(false);
    const navigation = useNavigation();
    const isFocused = useIsFocused();

    const fecthData = () => {
        setIsLoading(true);
        fetchOrders().then(response => setOrders(response.data))
            .catch(err => Alert.alert("Houve um erro ao buscar seus pedidos"))
            .finally(() => setIsLoading(false));
    }

    const handleOnPress = (order: Order) => {
      navigation.navigate('OrderDetails', {
          order
      });
    }
    
    useEffect(() =>{
        if (isFocused) {
            fecthData();
        }
    }, [isFocused]);

    return (
        <>
            <Header />
            <ScrollView style={styles.container}>
                {isLoading ? (
                    <Text>Busncaod Pedidos....</Text>
                ) : (
                    orders.map(order => (
                        <TouchableWithoutFeedback key={order.id} 
                        onPress={() => handleOnPress(order)}>
                            <OrderCard order={order} />
                        </TouchableWithoutFeedback>
                    ))
                )}
            </ScrollView>
        </>
    );
}

const styles = StyleSheet.create({
    container: {
        paddingRight: "5%",
        paddingLeft: "5%",
    }
});
